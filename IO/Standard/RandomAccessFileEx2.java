package Standard;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {
  public static void main(String args[]) {
    //             번호,국어,영어,수학
    int[] score = { 1, 100, 90, 80,
                    2, 70, 90, 100,
                    3, 100, 100, 100,
                    4, 70, 60, 80,
                    5, 70, 90, 100
    };
    
    try {
      RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
      for(int i = 0; i < score.length; i++) {
        raf.writeInt(score[i]);
      }
      
      // raf.seek(0); // 파일포인터의 위치를 처음으로 돌려놓는다.
      while(true) {
        // score2.dat파일은 생성돼지만 화면에는 아무것도 출력돼지 않는다.
        // 그 이유는 writeInt()를 수행하면서 파일 포인터의 위치가 마지막으로 이동되었기 때문에 아무것도 읽지 못하는 것이다.
        // 화면에 출력하기 전에 raf.seek(0)을 이용해 파일포인터의 위치를 처음으로 돌려놔야 한다.
        System.out.println(raf.readInt());
      }
    } catch (EOFException eof) {
      // readInt()를 호출했을 때 더 이상 읽을 내용이 없으면 EOFException이 발생
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
