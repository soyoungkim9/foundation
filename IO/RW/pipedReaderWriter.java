package RW;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

// PipedReader/PipedWriter는 쓰레드 간에 데이터를 주고받을 때 사용된다.
// 다른 스트림과는 달리 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고받는다.
// 그래서 입출력을 마친 후에는 어느 한쪽 스트림만 닫아도 나머지 스트림은 자동으로 닫힌다.
public class pipedReaderWriter {
  public static void main(String[] args) {
    InputThread inThread = new InputThread("InputThread");
    OutputThread outThread = new OutputThread("OutputThread");
    
    inThread.connect(outThread.getOutput());
    inThread.start();
    outThread.start();
  }
}

class InputThread extends Thread {
  PipedReader input = new PipedReader();
  StringWriter sw = new StringWriter();
  
  InputThread(String name) {
    super(name);
  }
  
  public void run() {
    try {
      int data = 0;
      
      while((data = input.read()) != -1) {
        sw.write(data);
      }
      System.out.println(getName() + " received : " + sw.toString());
    } catch (IOException e) {}
  }
  
  public PipedReader getInput() {
    return input;
  }
  
  public void connect(PipedWriter output) {
    try {
      input.connect(output);
    } catch(IOException e) {} // connect
  }
}

class OutputThread extends Thread {
  PipedWriter output = new PipedWriter();
  
  OutputThread(String name) {
    super(name);
  }
  
  public void run() {
    try {
      String msg = "Hello";
      System.out.println(getName() + " sent : " + msg);
      output.write(msg);
      output.close();
    } catch (IOException e) {}
  }
  
  public PipedWriter getOutput() {
    return output;
  }
  
  public void connect(PipedReader input) {
    try {
      output.connect(input);
    } catch (IOException e) {} // connect
  }
}
