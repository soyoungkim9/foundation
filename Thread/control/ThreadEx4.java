// join - 다른 쓰레드의 작업을 기다린다.
// sleep()과 다른 점으 join()은 현재 쓰레드가 아닌 특정쓰레드에 대해 동작하므로 static메서드가 아니다.
// ex) Thread.sleep(), th1.join()
package control;

public class ThreadEx4 {
  static long startTime = 0;
  
  public static void main(String[] args) {
    ThreadEx4_1 th1 = new ThreadEx4_1();
    ThreadEx4_2 th2 = new ThreadEx4_2();
    th1.start();
    th2.start();
    startTime = System.currentTimeMillis();
    
    try {
      th1.join();
      th2.join();
    } catch(InterruptedException e) {}
    
    System.out.println("소요시간:" + (System.currentTimeMillis() - ThreadEx4.startTime));
  }
}

class ThreadEx4_1 extends Thread {
  public void run() {
    for(int i = 0; i < 300; i++) {
      System.out.print(new String("-"));
    }
  }
}

class ThreadEx4_2 extends Thread {
  public void run() {
    for(int i = 0; i < 300; i++) {
      System.out.print(new String("|"));
    }
  }
}
