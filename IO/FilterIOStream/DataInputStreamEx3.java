package FilterIOStream;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx3 {
  public static void main(String[] args) {
    int sum = 0;
    int score = 0;
    
    // JDK1.7부터는 try-with-resources문을 이용해서 close()를 직접 호출하지 않아도 자동호출되도록 할 수 있다.
    try (FileInputStream fis = new FileInputStream("score.dat");
         DataInputStream dis = new DataInputStream(fis)) {
      while(true) {
        score = dis.readInt();
        System.out.println(score);
        sum += score;
      }
    } catch (EOFException e) {
      System.out.println("점수의 총합은 " + sum + "입니다.");
    } catch (IOException ie) {
      ie.printStackTrace();
    }
  }
}
