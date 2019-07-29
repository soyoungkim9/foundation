package FilterIOStream;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataOutputStreamEx2 {
  public static void main(String[] args) {
    // ByteArrayInputStream / ByteArrayOutputStream을 사용하면 byte단위의 데이터 변환 및 조작이 가능하다.
    // InputStream의 read()는 반환타입이 int이며 0~255의 값을 반환하므로 256을 더하거나 뺄 필요가 없다.
    // 반면에 read(byte[b])와 같이 byte배열을 사용하는 경우 상황에 따라 0~255범위의 값으로 변환해야할 필요가 있다.
    ByteArrayOutputStream bos = null;
    DataOutputStream dos = null;
    
    byte[] result = null;
    try {
      bos = new ByteArrayOutputStream();
      dos = new DataOutputStream(bos);
      // 여러 가지 종류의 자료형으로 출력한 경우, 읽을 대는 반드시 쓰인 순서대로 읽어야 한다.
      dos.writeInt(10);
      dos.writeFloat(20.0f);
      dos.writeBoolean(true);
    
      result = bos.toByteArray();
      
      String[] hex = new String[result.length];
      
      for(int i = 0; i < result.length; i++) {
        if (result[i] < 0) {
          hex[i] = String.format("%02x", result[i] + 256);
        } else {
          hex[i] = String.format("%02x", result[i]);
        }
      }
      System.out.println("10진수  :" + Arrays.toString(result));
      System.out.println("16진수  :" + Arrays.toString(hex));
      
      dos.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
