package ByteArrayIOStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx3 {
  public static void main(String[] args) {
    byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
    byte[] outSrc = null;
    byte[] temp = new byte[4];
  
    ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
    ByteArrayOutputStream output = new ByteArrayOutputStream();
  
    try {
      // available()은 블락킹(blocking)없이 읽어 올수 있는 바이이트의 수 이다.
      // 블락킹이란 데이터를 읽어 올 때 데이터를 기다리기 위해 멈춰있는 것을 뜻한다.
      // 예를 들어 사용자가 데이터를 입력하기 전까지 기다리고 있을 때 블락킹 상태에 있다고 한다.
      while(input.available() > 0) {
        int len = input.read(temp);
        // output.write(temp); // temp에 담긴 내용을 지우고 쓰는 것이 아니라 그냥 기존의 내용 위에 덮어쓴다.
        output.write(temp, 0, len); // 읽어온 만큼만 write한다.
      }
    } catch(IOException e) {}
    outSrc = output.toByteArray();
  
    System.out.println("Input Source : " + Arrays.toString(inSrc));
    System.out.println("temp : " + Arrays.toString(temp));
    System.out.println("Output Source : " + Arrays.toString(outSrc));
  }
}
