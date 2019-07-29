package FilterIOStream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx1 {
  public static void main(String[] args) {
    // DataInputStream은 DataInput 인터페이스를, DataOutputStream은 DataOutput인터페이스를 각각 구현했기 때문에
    // 데이터를 읽고 쓰는데 있어서 byte단위가 아닌, 8가지 기본 자료형의 단위로 읽고 쓸수 있다.
    // 예를들어, int값을 출력한다면, 4byte의 16진수로 출력된다.
    FileOutputStream fos = null;
    DataOutputStream dos = null;
    
    try {
      // 여기서 출력된 데이터는 이진 데이터(binary data)로 저장된다.
      // 문자 데이터(text data)가 아니므로 해당 파일을 열어보면 알 수 없는 글자들로 이루어져 있을 것이다.(16진코드)
      fos = new FileOutputStream("sample.dat");
      dos = new DataOutputStream(fos);
      dos.writeInt(10);
      dos.writeFloat(20.0f);
      dos.writeBoolean(true);
      
      dos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
