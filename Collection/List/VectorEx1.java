package List;

import java.util.Vector;

public class VectorEx1 {
  public static void main(String[] args) {
    Vector v = new Vector(5); // 용량이 5인 Vector를 생성한다.
    v.add("1");
    v.add("2");
    v.add("3");
    print(v);
    
    v.trimToSize();
    System.out.println("=== After trimToSize() ====");
    print(v);
    
    v.ensureCapacity(6);
    System.out.println("=== After ensureCapacity(6) ====");
    print(v);
  
    // Vector는 capacity가 부족할 경우 자동으로 기존 크기보다 2배의 크기로 증가된다.
    v.setSize(7);
    System.out.println("=== After setSize(7) ====");
    print(v);
    
    v.clear();
    System.out.println("=== After clear() ====");
    print(v);
  }
  static void print(Vector v) {
    System.out.println(v);
    System.out.println("size : " + v.size());
    System.out.println("capacity : " + v.capacity());
  }
}
