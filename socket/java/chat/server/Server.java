package chat.server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  // java chat.server.Server 8080
  public static void main(String[] args) {
    Socket socket = null;
    User user = new User();     // 채팅방에 접속해 있는 Client 관리 객체
    ServerSocket server_socket = null;

    int port = Integer.parseInt(args[0]);
    int count = 0;
    Thread thread[] = new Thread[10];

    try {
      server_socket = new ServerSocket(port);
      while(true) { // 1. Server의 메인쓰레드는 계속해서 Client 접속을 받는다.
        socket = server_socket.accept();

        thread[count] = new Thread(new Receiver(user, socket)); // 2. Client와 데이터를 주고받는 서브 스레드를 생성한다.
        thread[count].start();
        count++;
      }
    } catch (Exception e) {}
  }
}

// 출처 : https://lktprogrammer.tistory.com/64?category=672211