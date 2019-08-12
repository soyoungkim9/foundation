// yield() - 다른 쓰레드에게 양보한다.
// yield()와 interrupt()를 적절히 사용하면, 프로그램의 응답성을 높이고 보다 효율적인 실행이 가능하게 할 수 있다.
package control;

public class ThreadEx3 {
  public static void main(String[] args) {
    ThreadEx3_1 th1 = new ThreadEx3_1("*");
    ThreadEx3_1 th2 = new ThreadEx3_1("**");
    ThreadEx3_1 th3 = new ThreadEx3_1("***");
    th1.start();
    th2.start();
    th3.start();
  
    try {
      Thread.sleep(2000);
      th1.suspend();
      Thread.sleep(2000);
      th2.suspend();
      Thread.sleep(3000);
      th1.resume();
      Thread.sleep(3000);
      th1.stop();
      th2.stop();
      Thread.sleep(2000);
      th3.stop();
    } catch(InterruptedException e) {}
  
  }
}

class ThreadEx3_1 implements Runnable{
  boolean suspended = false;
  boolean stopped = false;
  
  Thread th;
  ThreadEx3_1(String name) {
    th = new Thread(this, name);
  }
  
  public void run() {
    while(!stopped) {
      if(!suspended) {
        System.out.println(Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch(InterruptedException e) {
          System.out.println(Thread.currentThread().getName() + "- interrupted");
        }
      } else {
        Thread.yield(); // 다른 쓰레드에게 양보한다.
      }
    }
    System.out.println(Thread.currentThread().getName() + "- stopped");
  }
  
  public void suspend() {
    suspended = true;
    th.interrupt();
    System.out.println(th.getName() + "- interrupt() by suspend()");
  }
  
  public void stop() {
    stopped = true;
    th.interrupt();
    System.out.println(th.getName() + "- interrupt() by stop()");
  }
  
  public void resume() { suspended = false; }
  public void start() { th.start();}
}

