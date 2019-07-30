package Standard;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class StandardIOEx2 {
  public static void main(String[] args) {
    PrintStream ps = null;
    FileOutputStream fos = null;
    
    try {
      fos = new FileOutputStream("test.txt");
      ps = new PrintStream(fos);
      System.setOut(ps); // System.out의 출력대상을 test.txt파일로 변경
    } catch (FileNotFoundException e) {
      System.err.println("File not found.");
    }
    
    System.out.println("Hello by System.out"); // test.txt파일에 저장된다.
    System.err.println("Hello by System.err"); // 콘솔에 출력한다.
  }
}
