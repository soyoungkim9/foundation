package Standard;

// 자바에서는 입력과 출력이 각각 분리되어 별도로 작업을 하도록 설계되어 있지만,
// RandomAccessFile은 하나의 클래스로 파일에 대한 입력과 출력을 모두 할 수 있다.
// 또한, 다른 입출력 클래스들은 입출력소스에 순차적으로 읽기/쓰기를 하기 때문에 읽기와 쓰기가 제한적인 반면
// RandomAccessFile클래스는 파일에 읽고 쓰는 위치에 제한이 없다.
// 이렇게 파일의 임의의 위치에 있는 내용에 대해서 작업하고자 한다면, 파일 포인터를 원하는 위치로 옮긴 다음 작업해야 한다.

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx1 {
  public static void main(String[] args) {
    try {
      RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
      System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
      raf.writeInt(100);
      System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
      raf.writeLong(100L);
      System.out.println("파일 포인터의 위치: " + raf.getFilePointer());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
