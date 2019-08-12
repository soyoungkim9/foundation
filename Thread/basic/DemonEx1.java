package basic;

// 데몬쓰레드(Demon thread)
// 데몬 쓰레드는 다른 일반 쓰레드의 작업을 돕는 보조적인 역할을 수행하는 쓰레드이다.
// 예시 : 가비지 컬렉터, 워드프로세서의 자동저장, 화면자동갱신 등
public class DemonEx1 implements Runnable{
  static boolean autoSave = false;
  
  public static void main(String[] args) {
    Thread t = new Thread(new DemonEx1());
    t.setDaemon(true);
    t.start();
    
    for(int i = 1; i <= 10; i++) {
      try {
        Thread.sleep(1000);
      } catch(InterruptedException e) {}
      System.out.println(i);
      
      if(i == 5)
        autoSave = true;
    }
  }
 
  public void run() {
    while(true) {
      try {
        Thread.sleep(3 * 1000);
      } catch(InterruptedException e){}
      
      if(autoSave) {
        autoSave();
      }
    }
  }
  
  public void autoSave() {
    System.out.println("작업파일이 자동저장되었습니다.");
  }
}
