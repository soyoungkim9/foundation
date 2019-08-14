package basic.sample;

// 멀티쓰레드를 사용하는 이유
// 대기 시간이 발생했을 때 기다리는 동안 다른 일을 처리할 수 있게 해서 처리속도를 빠르게 하기 위함

// 단, CPU코어 수가 적으면 쓰레드를 그 만큼 만들 수 없기 때문에 엄청나게 빨리지지는 않고,
// 데이터 양이 적을 때에도 속도가 많이 빨라지지 않기 때문에 쓰레드를 적절한 경우에 사용하는 것이 좋다.
public class MultiThreadSample implements Runnable{
  private static final String MSG_TEMPLATE = "출력중 [%s][%d]회";
  private String threadName;
  public MultiThreadSample(String threadName) {
    this.threadName = threadName;
  }
  
  @Override
  public void run() {
    for(int i = 1; i < 100; i++) {
      System.out.println(String.format(MSG_TEMPLATE, threadName, i));
    }
  }
  
  public static void main(String[] args) {
    MultiThreadSample runnable1 = new MultiThreadSample("thread1");
    MultiThreadSample runnable2 = new MultiThreadSample("thread2");
    MultiThreadSample runnable3 = new MultiThreadSample("thread3");
    
    Thread thread1 = new Thread(runnable1);
    Thread thread2 = new Thread(runnable2);
    Thread thread3 = new Thread(runnable3);
  
    thread1.start();
    thread2.start();
    thread3.start();
  }
}
