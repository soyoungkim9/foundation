package basic;

public class Multi2 {
  public static void main(String args[]) {
    Bank t1 = new Bank("ATM");
    Bank t2 = new Bank("은행");
    t1.start();
    t2.start();
  }
}

class Bank extends Thread {
  static Account obj = new Account();
  public Bank(){}
  public Bank(String name) {super(name); }
  
  @Override
  public void run() {
    while(true) {
      
      synchronized (obj) { // synchronized : 한 순간에 하나의 스레드만 실행하도록 한다.
        int money = (int)(Math.random()*3 + 1)*100;
        if(obj.balance >= money) {
          System.out.println(getName() + " : 원본 balance:" + obj.balance);
          System.out.println(getName() + " : 찾는 금액:" + money);
          obj.withdraw(money);
          System.out.println(getName() + " : 수정된 balance:" + obj.balance);
        } else {
          System.out.println("잔액 부족");
          break;
        }
      }
      
    }
  }
}

class Account {
  int balance = 1000;
  public void withdraw(int money) {
    if(balance >= money) {
      try {
        Thread.sleep(1000);
      } catch (Exception e) {}
      
      balance -= money;
    }
  }
}
