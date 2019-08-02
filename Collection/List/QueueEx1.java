package List;

import java.util.*;

public class QueueEx1 {
  
  static Queue q = new LinkedList();
  static final int MAX_SIZE = 5;
  
  public static void main(String[] args) {
    System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
    
    while(true) {
      System.out.print(">>");
      try {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
  
        if ("".equals(input     )) continue;
        
        if(input.equalsIgnoreCase("q")) {
          System.exit(0);
        } else if(input.equalsIgnoreCase("help")) {
          System.out.println("help - 도움말을 보여줍니다.");
          System.out.println("q 또는 Q - 프로그램을 종료합니다.");
          System.out.println("history - 최근에 입력한 명령어를 5개 보여줍니다.");
        } else if(input.equalsIgnoreCase("history")) {
          int index = 1;
          save(input);
          
          LinkedList tmp = (LinkedList)q;
          ListIterator iter = tmp.listIterator();
          while(iter.hasNext()) {
            System.out.println(index++ + "." + iter.next());
          }
        } else {
          save(input);
        }
      } catch (Exception e) {
        System.out.println("입력오류 입니다.");
      }
      
    }
  }
  
  static void save(String input) {
    System.out.println(input);
    if(q.size() >= MAX_SIZE) {
      q.remove();
      q.offer(input);
    } else {
      q.offer(input);
    }
  }
}
