package ByteArrayIOStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2 {
  public static void main(String[] args) {
    // byte배열을 사용해서 한 번에 배열의 크기만큼 읽고 쓸 수 있다.
    // 배열을 이용한 입출력은 작업의 효율을 증가시킨다.
    byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
    byte[] outSrc = null;
    byte[] temp = new byte[10];
    
    ByteArrayInputStream input = null;
    ByteArrayOutputStream output = null;
    
    input = new ByteArrayInputStream(inSrc);
    output = new ByteArrayOutputStream();
    
    input.read(temp,0,temp.length);
    output.write(temp,5,5);
    
    outSrc = output.toByteArray();
    System.out.println("Input Source : " + Arrays.toString(inSrc));
    System.out.println("temp : " + Arrays.toString(temp));
    System.out.println("Output Source : " + Arrays.toString(outSrc));
  }
}
