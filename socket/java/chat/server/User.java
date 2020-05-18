package chat.server;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class User {
  // Client정보를 관리해주는 객체
  // 한 채팅방에 존재하는 Client의 이름, DataoutputStream객체를 쌍으로하는 HashMap을 가지고 있다.
  HashMap<String,DataOutputStream> clientmap = new HashMap<String,DataOutputStream>();

  public synchronized void AddClient(String name, Socket socket) {
    try {
      sendMsg(name+" 입장하셨습니다.","Server");
      clientmap.put(name, new DataOutputStream(socket.getOutputStream()));
      System.out.println("채팅 참여 인원 : " + clientmap.size());
    } catch(Exception e) {}
  }

  public synchronized void RemoveClient(String name) {
    try {
      clientmap.remove(name);
      sendMsg(name + " 퇴장하셨습니다.", "Server");
      System.out.println("채팅 참여 인원 : " + clientmap.size());
    } catch(Exception e) {}
  }

  public synchronized void sendMsg(String msg, String name) throws Exception {
    Iterator iterator = clientmap.keySet().iterator();
    // msg를 clientmap객체에 들어있는 모든 사용자에게 보낸다.
    while(iterator.hasNext()) {
      String clientname = (String)iterator.next();
      clientmap.get(clientname).writeUTF(name + ":" + msg);
    }
  }
}

// 출처 : https://lktprogrammer.tistory.com/64?category=672211
