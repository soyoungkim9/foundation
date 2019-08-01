package List;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {
  public static void main(String[] args) {
    Stack st = new Stack();
    Queue q= new LinkedList(); // Queue는 인터페이스로만 정의했을 뿐 별도 클래스를 제공하지 않는다ㅠ
    
    st.push("0");
    st.push("1");
    st.push("2");
    
    q.offer("0");
    q.offer("1");
    q.offer("2");
    
    System.out.println("= Stack =");
    while(!st.empty()) {
      System.out.println(st.pop());
    }

    System.out.println("= Queue =");
    while(!q.isEmpty()) {
      System.out.println(q.poll());
    }
  }
}
