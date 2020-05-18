package chat.server;

import java.io.DataInputStream;
import java.net.Socket;

public class Receiver implements Runnable {
  Socket socket;
  DataInputStream in;
  String name;
  User user;

  public Receiver(User user, Socket socket) throws Exception {
    this.user = user;
    this.socket = socket;
    in = new DataInputStream(socket.getInputStream());
    // Client로부터 닉네임 정보를 읽어들이고 AddClient메서드를 호출한다.
    this.name = in.readUTF();
    user.AddClient(name, socket);
  }

  public void run() {
    try {
      while(true) {
        // Client로부터 메시지를 읽어들이고 읽어들인 메시지를 SendMsg 호출하여 다른 Client에게 전달
        String msg = in.readUTF();
        user.sendMsg(msg, name);
      }
    } catch (Exception e) {
      // Catch문에 걸릴 경우 Client가 접속을 끊은 것이므로 User객체에서 해당 Client의 정보를 제거한다.
      user.RemoveClient(this.name);
    }
  }
}

// 출처 : https://lktprogrammer.tistory.com/64?category=672211
