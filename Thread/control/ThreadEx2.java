// interrupt()와 interrupted() - 쓰레드의 작업을 취소한다.
// 예시1 : 큰파일의 용량을 다운로드받을 때 시간이 너무 오래 걸리면 중간에 다운로드를 취소할 수 있다.
// 예시2 : 멈춰있던 쓰레드를 깨워서 실행가능한 상태로 만들 수 있다. (일시정지상태(WAITING) -> 실행대기상태(RUNNABLE))
package control;

import javax.swing.*;

public class ThreadEx2 {
  public static void main(String[] args) {
    ThreadEx2_1 th1 = new ThreadEx2_1();
    th1.start();
    
    String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
    System.out.println("입력하신 값은 " + input + "입니다.");
    th1.interrupt();
    System.out.println("isInterrupted() : " + th1.isInterrupted());
  }
}

class ThreadEx2_1 extends Thread {
  public void run() {
    int i = 10;
    
    while(i != 0 && !isInterrupted()) {
      System.out.println(i--);
      // for(long x = 0; x < 2500000000L; x++); /* 중간에 interrupt가 발생하면 thread 중단 */
      try {
        /* 1. Thread.sleep(1000)에 의해 InterruptedException이 발생한다.*/
        Thread.sleep(1000);
      } catch(InterruptedException e) {
        /* 2. ssleep()에 의해 쓰레드가 잠시 맘춰있을때, InterruptedException이 발생되고
        쓰레드의 interrupted상태는 false로 자동 초기화 된다.*/
        /* 3. interrupted의 상태를 true로 바꿔주기 위해서는 catch블럭에 interrupt()를 추가로 넣어주어야 한다.*/
        // interrupt();
      }
    }
    System.out.println("카운트가 종료되었습니다.");
  }
}
