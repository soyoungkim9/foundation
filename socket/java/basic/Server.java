package basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
  // java basic.Server 8080
  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("######## Argument is Null ########");
      return;
    }

    // port num = args[0]
    int port = Integer.parseInt(args[0]);
    // 1. 서버소켓 생성, 포트 바인 (Create a Server Socket)
    try(ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("Server is listening on port " + port);

      while (true) {
        // 2. 클라이언트로 부터 연결을 기다리고 요청이 오면 수락 (Listen for a connection)
        Socket socket = serverSocket.accept();
        System.out.println("[ " + socket.getInetAddress() + " ] client connected.");
        // 3. 응답이 있으면 소켓과 연결된 클라이언트에게 데이터를 보낸다. (Send Data to the client)
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(new Date().toString());

        // 4. 클라이언트 소켓에서 가져온 데이터를 읽는다. (Read data from the Client)
        InputStream input = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        System.out.println("######## msg: " + reader.readLine());
      }
    } catch (IOException e) {
      System.out.println("Server exception: " + e.getMessage());
      e.printStackTrace();
    }
  }
}

//  출처 : https://woolbro.tistory.com/29?category=818993
