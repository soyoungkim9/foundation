package FilterIOStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {
  // BufferedInputStream / BufferedOutputStream은 스트림의 입출력 효율을 높이기 위해 버퍼를 사용하는 보조스트림이다.
  // 한 바이트씩 입출력하는 것 보다는 버퍼(바이트배열)를 이용해서 한 번에 여러 바이트를 입출력하는 것이 빠르기 때문에
  // 대부분의 입출력 작업에 사용된다.
  public static void main(String[] args) {
    try {
      FileOutputStream fos = new FileOutputStream("123.txt");
      BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
      // 버퍼가 가득 찾을 때만 출력소스에 출력을한다.
      for(int i = '1'; i < '9'; i++) {
        bos.write(i);
      }
      // 버퍼에 남아있는 모든 데이터를 출력한다.
      bos.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
