package basic.sample;

// wait() - 스레드를 일시정지 상태로 만듬
// notify() - 일시정지 상태에 있는 다른 스레드를 실행대기 상태로 만듬
public class WorkObject {
  public synchronized void methodA() {
    System.out.println("ThreadA의 methodA() 작업 실행");
    notify();
    try {
      wait();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public synchronized void methodB() {
    System.out.println("ThreadB의 methodB() 작업 실행");
    notify();
    try {
      wait();
    } catch(InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class ThreadA extends Thread {
  private WorkObject workObject;
  
  ThreadA(WorkObject workObject) {
    this.workObject = workObject;
  }
  
  public void run() {
    for(int i = 0; i < 10; i++) {
      workObject.methodA();
    }
  }
}

class ThreadB extends Thread {
  private WorkObject workObject;
  
  ThreadB(WorkObject workObject) {
    this.workObject = workObject;
  }
  
  public void run() {
    for(int i = 0; i < 10; i++) {
      workObject.methodB();
    }
  }
}

class WaitNotifyExam {
  public static void main(String[] args) {
    WorkObject shareObject = new WorkObject();
    
    ThreadA threadA = new ThreadA(shareObject);
    ThreadB threadB = new ThreadB(shareObject);
    
    threadA.start();
    threadB.start();
    
  }
}
