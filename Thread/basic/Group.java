package basic;// 쓰레드 그룹(Thread basic.Group)은 서로 관련된 쓰레드를 그룹으로 묶어 관리 할 수 있다.
// 우리가 생성하는 모든 쓰레드 그룹은 main쓰레드 그룹의 하위 쓰레드 그룹이 되며,
// 쓰레드 그룹을 지정하지 않고 생성한 쓰레드는 자동적으로 main쓰레드 그룹에 속하게 된다.

public class Group {
  public static void main(String[] args) {
    ThreadGroup main = Thread.currentThread().getThreadGroup();
    ThreadGroup grp1 = new ThreadGroup("Group1");
    ThreadGroup grp2 = new ThreadGroup("Group2");
    
    ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");
    grp1.setMaxPriority(3); // 쓰레드 그룹 grp1의 최대 우선순위를 3으로 변경
    
    Runnable r = new Runnable() {
      public void run() {
        try {
          Thread.sleep(1000); // 쓰레드를 1초간 멈추게 한다.
        } catch (InterruptedException e) {}
      }
    };
    
    new Thread(grp1, r, "th1").start();
    new Thread(subGrp1, r, "th2").start();
    new Thread(grp2, r, "th3").start();
    
    System.out.println(">>List of ThreadGroup : " + main.getName()
      + ", Active ThreadGroup : " + main.activeCount()
      + ", Active Thread: " + main.activeCount()
    );
    main.list();
  }
}
