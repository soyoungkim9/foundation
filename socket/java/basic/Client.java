package basic;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
  // java basic.Client localhost 8080
  public static void main(String[] args) {
    if(args.length < 2) {
      System.out.println("######## Need More Arguments ########");
      return;
    }

    // host name = args[0], port num = args[1]
    String hostname = args[0];
    int port = Integer.parseInt(args[1]);
    for(int i = 0; i < 10; i++) {
      // 1. 서버에 대한 연결 시
      try (Socket socket = new Socket(hostname, port)) {
        // 2. 서버에 데이터 보내기
        OutputStream out = socket.getOutputStream();
        String realStr = "Request !!";
        out.write(realStr.getBytes());
        // 3. 서버에서 데이터 읽기
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        String time = reader.readLine();

        System.out.println(time);
      } catch (UnknownHostException e) {
        System.out.println("Server not found: " + e.getMessage());
      } catch (IOException e) {
        System.out.println("I/O error: " + e.getMessage());
      }
    }
  }
}

//  출처 : https://woolbro.tistory.com/29?category=818993
