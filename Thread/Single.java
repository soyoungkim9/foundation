// 싱글 코어에서 단순히 CPU만을 사용하는 계산작업이라면 오히려 멀티쓰레드보다 싱글쓰레드로 프로그래밍하는 것이 더 효율적이다.
public class Single {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    
    for(int i = 0; i < 300; i++)
      System.out.printf("%s", new String("-"));
    
    System.out.print("소요시간1:" + (System.currentTimeMillis() - startTime));
  
    for(int i = 0; i < 300; i++)
      System.out.printf("%s", new String("|"));
  
    System.out.print("소요시간2:" + (System.currentTimeMillis() - startTime));
  }
}
