package basic;// 쓰레드가 가질 수 있는 우선순위의 범위는 1~10이며 숫자가 높을수록 우선순위가 높다.
// setPriority(int new Priority), getPriority()

// 싱글코어에서는 우선순위가 높은것에 더 많은 양의 실행시간이 주어져 더 빨리 처리 될 수 있다.
// 하지만 멀티코어에서는 쓰레드의 우선순위에 따른 차의가 거의 없다.(OS마다 다른 방식으로 스케쥴링하기 때문에 다른 결과를 얻을수도 있다!!)
// 차라리 쓰레드에 우선순위를 부여하는 대신 작업에 우선순위를 두어 PriorityQueue에 저장해 놓고,
// 우선순위가 높은 작업이 먼저 처리되도록 하는 것이 더 나을 수도 있다.

class multi {
  static long startTime = 0;
  
  public static void main(String[] args) {
    ThreadEx1 th1 = new ThreadEx1();
    ThreadEx2 th2 = new ThreadEx2();
    
    // th2.setPriority(7); /* 우선순위 지정*/
    
    System.out.println("Priority of th1(-) : " + th1.getPriority());
    System.out.println("Priority of th2(|) : " + th2.getPriority());
    th1.start();
    th2.start();
  }
}

class ThreadEx1 extends Thread {
  public void run() {
    for(int i = 0; i < 300; i++) {
      System.out.printf("%s", new String("-"));
      for(int x = 0; x < 10000000; x++);
    }
  }
}

class ThreadEx2 extends Thread {
  public void run() {
    for(int i = 0; i < 300; i++) {
      System.out.printf("%s", new String("|"));
      for(int x = 0; x < 10000000; x++);
    }
  }
}
