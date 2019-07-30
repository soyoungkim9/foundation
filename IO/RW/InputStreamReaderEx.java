package RW;

// InputStreamReader/OutputStreamReader는 바이트기반 스트림을 문자기반 스트림으로 연결시켜주는 역할을 한다.
// 인코딩을 지정해 주지 않으면 OS에서 사용하는 인코딩을 사용해 파일을 해석해서 보여주기 때문에 원래작성된 데로 볼 수 없을 수 있다.
// 그럴땐 적절한 인코딩을 지정해 주어야 한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderEx {
  public static void main(String[] args) {
    String line = "";
    try {
      InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
      BufferedReader br = new BufferedReader(isr);
  
      System.out.println("사용중인 OS의 인코딩 : " + isr.getEncoding());
  
      do {
        System.out.print("문장을 입력하세요. 마치려면 q를 입력하세요.>");
        line = br.readLine();
        System.out.println("입력하신문장 : " + line);
      } while(!line.equalsIgnoreCase("q"));
  
      br.close();
      System.out.println("프로그램을 종료합니다.");
  
    } catch (IOException e) {}
  }
}
