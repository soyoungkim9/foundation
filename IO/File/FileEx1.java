package File;

import java.io.File;

// 자바 에서는 File클래스를 통해서 파일과 디렉토리를 다룰 수 있다.
public class FileEx1 {
  public static void main(String[] args) {
    if(args.length != 1) {
      System.out.println("USAGE : java FileEx1 DIRECTORY");
      System.exit(0);
    }
    
    File f = new File(args[0]);
    
    if(!f.exists() || !f.isDirectory()) {
      System.out.println("유효하지 않은 디렉토리입니다.");
      System.exit(0);
    }
    
    File[] files = f.listFiles();
    
    for(int i = 0; i <files.length; i++) {
      String fileName = files[i].getName();
      System.out.println(files[i].isDirectory() ? "["+fileName+"]" : fileName);
    }
  }
}
