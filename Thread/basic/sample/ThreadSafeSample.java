package basic.sample;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 쓰레드 세이프
// 멀티쓰레드로 동작하는 프로그램에서 개발자가 의도한 대로 동작하는 것
public class ThreadSafeSample {
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
          String result = unsafeDateFormat.format(date1);
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
          String result = unsafeDateFormat.format(date2);
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

/*
원하는 결과는 Thread1은 1989/03/10 만 100번 나오고 Thread2는 2020/06/20 만 100번 나와야 한다.
하지만 2020/06/10, 1989/03/20 이런 이상한 내용이 섞여나온다!

그 이유는 SimpleDateFormat클래스를 동시에 사용하려고 했기때문이다.
내부적으로 처리 속도가 굉장히 빠른데 그 와중에 겹쳐서 그런 결과가 나온것이다.

전혀 다른 일을 처리할 때는 상관없으나 공유자원을 참고하려면 이러한 문제를 반드시 처리해야 한다.

다양한 해결법중 하나로 synchronized가 있다.
*/
