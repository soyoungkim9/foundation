package control;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// notify()는 그저 waiting pool에서 대기 중인 쓰레드 중에서 하나를 임의로 선택해서 통지를 받는다.
// 운이 나쁘면 어느 한 쓰레드는 계속 통지를 받지 못하고 오랫동안 기다리는 상태가되는데 이것을 '기아(starvation)현상'이라고 한다.

// 이 현상을 막기위해 notifyAll()을 사용할 수 있는데,
// 일단 모든 쓰레드에게 통지를 하면, 다시 waiting pool에 들어가더라도 요리사 쓰레드는 결국 lock을 얻어서 작업을 진행할 수 있다.

// notifyAll()로 기아현상은 막았지만, 불필요하게 lock을 얻기 위해서 쓰레드끼리 경쟁하게 된다.
// 이처럼 여러 쓰레드가 lock을 얻기 위해 서로 경쟁하는 것을 '경쟁 상태(race condition)'라고 한다.

// 이런 경쟁 상태를 개선하기 위해 각 쓰레드를 구별해서 통지하는 것이 필요하다.
// Lock과 Condition을 이용하면, 선별적인 통지가 가능하다.

// Condition을 더 세분화하면, 기다리는 시간을 더 줄일 수 있다.
public class ThreadWaitEx1 {
  public static void main(String[] args) throws Exception {
    Table table = new Table();
    
    new Thread(new Cook(table), "COOK1").start();
    new Thread(new Customer(table, "donut"), "Cust1").start();
    new Thread(new Customer(table, "burger"), "Cust2").start();
    
    Thread.sleep(2000);
    System.exit(0);
  }
}

class Customer implements Runnable {
  private Table table;
  private String food;
  
  Customer(Table table, String food) {
    this.table = table;
    this.food = food;
  }
  
  @Override
  public void run() {
    while(true) {
      try {Thread.sleep(100);} catch (InterruptedException e) {}
      String name = Thread.currentThread().getName();
      table.remove(food);
      System.out.println(name + " ate a " + food);
    }
  }
}

class Cook implements Runnable {
  private Table table;
  
  Cook(Table table) {this.table = table;}
  
  @Override
  public void run() {
    while(true) {
      int idx = (int)(Math.random()*table.dishNum());
      table.add(table.dishNames[idx]);
      
      try { Thread.sleep(10);} catch (InterruptedException e) {}
    }
  }
}

class Table {
  String[] dishNames = {"donut","donut","burger"};
  final int MAX_FOOD = 6;
  private ArrayList<String> dishes = new ArrayList<>();
  
  private ReentrantLock lock = new ReentrantLock();
  private Condition forCook = lock.newCondition(); // 요리하는 애
  private Condition forCust1 = lock.newCondition(); // 도넛만 먹는애
  private Condition forCust2 = lock.newCondition(); // 버거만 먹는애
  
  public /*synchronized*/ void add(String dish) {
    lock.lock();
    
    try {
      while(dishes.size() >= MAX_FOOD) {
        String name = Thread.currentThread().getName();
        System.out.println(name+" is waiting.");
        try {
          // wait(); // COOK 쓰레드를 기다리게 한다.
          forCook.await(); // COOK 쓰레드를 기다리게 한다.
          Thread.sleep(500);
        } catch(InterruptedException e) {}
      }
      dishes.add(dish);
      // notify(); // 기다리고 있는 CUST를 깨운다.
      if(dish.equals("donut")) {
        forCust1.signal(); // 기다리고 있는 CUST1를 깨운다.
      } else {
        forCust2.signal(); // 기다리고 있는 CUST2를 깨운다.
      }
      System.out.println("Dishes:" + dishes.toString());
    } finally {
      lock.unlock();
    }
  }
  
  public void remove(String dishName) {
    lock.lock();
    String name = Thread.currentThread().getName();
    try {
      /*synchronized(this) {*/
      while(dishes.size() == 0) {
        System.out.println(name+" is waiting.");
        try {
          // wait(); // CUST 쓰레드를 기다리게 한다.
          forCust1.await(); // CUST1 쓰레드를 기다리게 한다
          forCust2.await(); // CUST2 쓰레드를 기다리게 한다
          Thread.sleep(500);
        } catch(InterruptedException e){}
      }
  
      while(true) {
        for(int i = 0; i < dishes.size(); i++) {
          if(dishName.equals(dishes.get(i))) {
            dishes.remove(i);
            // notify(); // 잠자고 있는 COOK을 깨운다.
            forCook.signal(); // 잠자고 있는 COOK을 깨운다.
            return;
          }
        }
    
        try {
          System.out.println(name + "is waiting.");
          // wait(); // 원하는 음식이 없는 CUST 쓰레드를 기다리게 한다.
          if(!dishName.equals("donut")) {
            forCust1.await(); // 원하는 음식이 없는 CUST1 쓰레드를 기다리게 한다
          } else {
            forCust2.await(); // 원하는 음식이 없는 CUST2 쓰레드를 기다리게 한다
          }
          
          Thread.sleep(500);
        } catch (InterruptedException e) {}
      }
      /*}*/
    } finally {
      lock.unlock();
    }
  }
  public int dishNum() {return dishNames.length;}
}