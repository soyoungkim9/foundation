package FilterIOStream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx1 {
  public static void main(String args[]) {
    // 문자로 데이터를 저장하면, 다시 데이터를 읽어 올때 문자들을 실제 값으로 변환하는 과정과
    // 또 읽어야 할 데이터의 개수를 결정해야 하는 번거로움이 있다.
    // 하지만 이처럼 DataInputStream과 DataOutputStream을 사용하면, 데이터를 변활할 필요도 없고,
    // 자리수를 세어서 따지지 않아도 되므로 편리하고 빠르게 데이터를 저장하고 읽을 수 있게 된다.
    try {
      FileInputStream fis = new FileInputStream("sample.dat");
      DataInputStream dis = new DataInputStream(fis);
      
      System.out.println(dis.readInt());
      System.out.println(dis.readFloat());
      System.out.println(dis.readBoolean());
      dis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
