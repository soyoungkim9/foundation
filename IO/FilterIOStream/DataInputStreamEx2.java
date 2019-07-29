package FilterIOStream;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx2 {
  public static void main(String[] args) {
    int sum = 0;
    int score = 0;
  
    FileInputStream fis = null;
    DataInputStream dis = null;
    
    try {
      fis = new FileInputStream("score.dat");
      dis = new DataInputStream(fis);
      
      // DataInputStream의 readInt()와 같이 데이터를 읽는 메서드는 더 이상 읽을 데이터가 없으면 EOFException을 발생시킨다.
      // 그래서 다른 입력스트림들과는 달리 무한반복문과 EOFException을 처리하는 catch문을 이용해서 데이터를 읽는다.
      // 원래 while문으로 작업을 마친 후에 스트림을 닫아 줘야 하는 데, while문이 무한 반복문이기 때문에
      // finally블럭에서 스트림을 닫도록 처리하였다.
      while(true) {
        score = dis.readInt();
        System.out.println(score);
        sum += score;
      }
    } catch (EOFException e) {
      System.out.println("점수의 총합은 " + sum + "입니다.");
    } catch (IOException ie) {
      ie.printStackTrace();
    } finally {
      try {
        if(dis != null)
          dis.close();
      } catch(IOException ie) {
        ie.printStackTrace();
      }
    }
  }
}
