package RW;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterEx {
  public static void main(String[] args) {
    String inputData = "ABCD";
    StringReader input = new StringReader(inputData);
    // StringWriter에 출력되는 데이터는 내부의 StringBuffer에 저장된다.
    StringWriter output = new StringWriter();
   
    int data = 0;
    try {
      while ((data = input.read()) != -1) {
        output.write(data);
      }
    } catch (IOException e) {}
    
    System.out.println("Input Data : " + inputData);
    System.out.println("Output Data : " + output.toString());
    // StringBuffer에 저장된 문자열을 반환한다.
    System.out.println("Output Data : " + output.getBuffer().toString());
  }
}
