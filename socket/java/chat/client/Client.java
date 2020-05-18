package chat.client;

import java.io.*;
import java.net.Socket;

public class Client {
  // java chat.client.Client localhost 8080
  public static void main(String[] args) {
    Socket socket = null;
    DataInputStream in = null;  // Server로 부터 데이터를 읽어들이기 위한 입력스트림
    BufferedReader in2 = null;  // 키보드로부터 읽어들이기 위한 입력스트림
    DataOutputStream out = null;

    String hostname = args[0];
    int port = Integer.parseInt(args[1]);
    try {
      socket = new Socket(hostname,port);
      in = new DataInputStream(socket.getInputStream());
      in2 = new BufferedReader(new InputStreamReader(System.in));
      out = new DataOutputStream(socket.getOutputStream());

      System.out.print("닉네임을 입력해주세요 : ");
      String data = in2.readLine();

      out.writeUTF(data); // 서버로 닉네임을 전
      Thread th = new Thread(new Send(out)); // 사용자 키보드로부터 메시지를 입력받고 서버로 전송
      th.start();
    } catch(IOException e) {}
    try {
      // Client의 메인 쓰레드는 서버로부터 데이터 읽어들이는 것만 반복
      while(true) {
        String str2 = in.readUTF();
        System.out.println(str2);
      }
    } catch (IOException e) {}
  }
}

// 출처 : https://lktprogrammer.tistory.com/64?category=672211