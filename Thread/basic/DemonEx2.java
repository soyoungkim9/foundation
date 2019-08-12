package basic;

import java.util.Iterator;
import java.util.Map;

public class DemonEx2 {
  public static void main(String[] args) {
    DemonEx2_1 t1 = new DemonEx2_1("Thread1");
    DemonEx2_2 t2 = new DemonEx2_2("Thread2");
    t1.start();
    t2.start();
  }
}

class DemonEx2_1 extends Thread {
  DemonEx2_1(String name) {
    super(name);
  }
  
  public void run() {
    try {
      sleep(5 * 1000);
    } catch (InterruptedException e) {}
  }
}

class DemonEx2_2 extends Thread {
  DemonEx2_2(String name) {
    super(name);
  }
  
  public void run() {
    // getAllStackTraces() : 실행 중 또는 대기상태, 즉 작업이 완료되지 않은 모든 쓰레드의 호출스택을 출력할 수 있다.
    Map map = getAllStackTraces();
    Iterator it = map.keySet().iterator();
    
    int x = 0;
    while(it.hasNext()) {
      Object obj = it.next();
      Thread t = (Thread)obj;
      StackTraceElement[] ste = (StackTraceElement[])(map.get(obj));
      
      System.out.println("[" + ++x + "] name : " + t.getName()
        + ", group : " + t.getThreadGroup().getName()
        + ", demon : " + t.isDaemon());
      
      for(int i = 0; i < ste.length; i++) {
        System.out.println(ste[i]);
      }
      
      System.out.println();
    }
  }
}
