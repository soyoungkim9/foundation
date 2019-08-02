package List;

import java.util.PriorityQueue;
import java.util.Queue;

// PriorityQueue
// 저장순서에 관계없이 우선순위가 높은 것부터 꺼낸다.
// 우선순위는 숫자가 작을수록 높다.
// 객체가 저장되는 경우 각 객체의 크기를 비교할 수 있는 방법을 제공해야 한다.

// Deque
// Queue와 달리, Deque는 양쪽 끝에 추가/삭제가 가능하다.
public class PriorityQueueEx {
  public static void main(String[] args) {
    Queue pq = new PriorityQueue();
    pq.offer(3);
    pq.offer(1);
    pq.offer(5);
    pq.offer(2);
    pq.offer(4);
    System.out.println(pq);
    
    Object obj = null;
    while((obj = pq.poll())!= null)
      System.out.println(obj);
  }
}
