package basic.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 쓰레드의 동기화 - synchronized
// 한 쓰레드가 진행 중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는 것

// 임계 영역은 멀티쓰레드 프로그램의 성능을 좌우하기 때문에 가능하면 메서드 전체에 락을 거는 것보다
// synchronized블럭으로 임계 영역을 최소화해서 보다 효율적인 프로그램이 되도록 해야한다.
public class SynchronizedSample {
  public static void main(String[] args) {
    // 안전하지 않은 객체
    DateFormat unsafeDateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Calendar cal1 = Calendar.getInstance();
    cal1.set(1989,Calendar.MARCH,10); // 1989/03/10
    Date date1 = cal1.getTime();
    Calendar cal2 = Calendar.getInstance();
    cal2.set(2020, Calendar.JUNE,20); // 2020/06/20
    Date date2 = cal2.getTime();
    
    Thread thread1 = new Thread(() -> {
      for(int i = 0; i < 100; i++) {
        try {
          String result;
          // synchronized(인수)에 락을 걸어서 쓰레드끼리 동시에 사용하지 못하게 막을 수 있다.
          // 따라서 기다리는 시간이 있다보니 기존에 멀티쓰레드를 그냥 쓰던 방법보다 속도는 느리게 나온다. (약 100배 정도 느리게나옴..)
          // 하지만 개발자가 기대하는대로 실행될 수 있다.
          // 물론 이를 개선하는 방법도 있다.
          synchronized (unsafeDateFormat) { // synchronized
            result = unsafeDateFormat.format(date1);
          }
          System.out.println("Thread1 : " + result);
        } catch(Exception e) {
          e.printStackTrace();
          break;
        }
      }
    });
    Thread thread2 = new Thread(() -> {
      for(int i = 0; i < 100; i++) {
        try {
          String result;
          synchronized (unsafeDateFormat) { // synchronized
            result = unsafeDateFormat.format(date2);
          }
          System.out.println("Thread2 : " + result);
        } catch(Exception e) {
          e.printStackTrace();
          break;
        }
      }
    });
    
    thread1.start();
    thread2.start();
  }
}
