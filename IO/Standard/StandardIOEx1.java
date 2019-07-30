package Standard;

// 표준입출력은 콘솔(console, 도스창)을 통한 데이터 입력과 출력을 의미한다.
// 자바에서 표준입출력(Standard I/O)을 위해 3가지 입출력 스트림
// System.in, System.out, System.err를 제공한다.
import java.io.IOException;

public class StandardIOEx1 {
  public static void main(String[] args) {
    try {
      int input = 0;
      
      while((input = System.in.read()) != -1) {
        System.out.println("input :" + input + ", (char)input : " + (char)input);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
