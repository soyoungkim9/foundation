package basic.sample;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 쓰레드 풀
// 쓰레드 수를 제한하지 않으면 메모리를 다 잡아먹을 만큼의 쓰레드를 만들 수 있다.
// 쓰레드 풀을 이용해서 쓰레드를 생성할 때 최대개수를 지정할 수 있다.
public class ThreadPoolSample implements Runnable {
  private static final String MSG_TEMPLATE = "출력중 [%s][%d]회";
  private String threadName;
  public ThreadPoolSample(String threadName) {
    this.threadName = threadName;
  }
  
  @Override
  public void run() {
    for(int i = 1; i < 100; i++) {
      System.out.println(String.format(MSG_TEMPLATE, threadName, i));
    }
  }
  
  public static void main(String[] args) {
    ThreadPoolSample runnable1 = new ThreadPoolSample("thread1");
    ThreadPoolSample runnable2 = new ThreadPoolSample("thread2");
    ThreadPoolSample runnable3 = new ThreadPoolSample("thread3");
  
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    executorService.execute(runnable1);
    executorService.execute(runnable2);
    executorService.execute(runnable3);
    
    executorService.shutdown(); // 모든 작업들을 다 '처리'하고 쓰레드풀을 중지시킨다.
    try {
      if(!executorService.awaitTermination(5, TimeUnit.MINUTES)) { // 5분안에 쓰레드풀의 작업이 전부 수행하지 못하면
        executorService.shutdown();
      }
    } catch(InterruptedException e) {
      e.printStackTrace();
      executorService.shutdownNow(); // 즉시 중지시킨다.
    }
  }
}
