package RW;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

// Reader/Writer 문자기반 스트림은 2byte로 스트림을 처리한다.
// Reader/Writer 그리고 그 자손들은 여러 종류의 인코딩과 자바에서 사용하는 유니코드(UTF-16)간의 변환을 자동적으로 처리한다.
public class FileReaderEx {
  public static void main(String[] args) {
    try {
      String fileName = "test.txt";
      FileInputStream fis = new FileInputStream(fileName);
      FileReader fr = new FileReader(fileName);
      
      int data = 0;
      /* FileInputStream을 이용해여 파일 내용을 읽어 화면에 출력하기*/
      while((data = fis.read()) != -1) {
        System.out.print((char)data); /* 한글깨짐 */
      }
      System.out.println();
      fis.close();

      /* FileReader를 이용해여 파일 내용을 읽어 화면에 출력하기*/
      while((data = fr.read()) != -1) {
        System.out.print((char)data); /* 정상출력 */
      }
      System.out.println();
      fr.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
