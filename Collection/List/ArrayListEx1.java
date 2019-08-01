package List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// List인터페이스는 중복을 허용하면서 저장순서가 유지된다.
public class ArrayListEx1 {
  public static void main(String[] args) {
    // List의 크기를 여유있게 잡는다.
    // 공간이 모자라면 자동으로 크기를 늘려주긴 하지만 그 과정에서 처리시간이 좀 더 오래걸린다.
    ArrayList list1 = new ArrayList(10);
    list1.add(new Integer(5));
    list1.add(new Integer(4));
    list1.add(new Integer(2));
    list1.add(new Integer(0));
    list1.add(new Integer(1));
    list1.add(new Integer(3));
    ArrayList list2 = new ArrayList(list1.subList(1,4));
    print(list1, list2);
    
    Collections.sort(list1);
    Collections.sort(list2);
    print(list1, list2);
    System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
    
    list2.add("B");
    list2.add("C");
    list2.add(3, "A"); // 기존에 있던 순서를 밀어내고 원하는 인덱스로 더해진다.
    print(list1, list2);
    
    list2.set(3, "AA"); // 기존에 있던 인덱스를 수정한다.
    print(list1, list2);
    
    System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
    print(list1, list2);
    
    // list2에서 list1에 포함된 객체를 삭제한다.
    // list2.size()-1부터 감소시키면서 반복해야 한다.
    // 그 이유는 변수 i를 증가시키면서 삭제하면, 한 요소가 삭제 될때 마다 빈공간을 채우기 때문에 올바른 결과값을 얻을 수 없다.
    for(int i = list2.size()-1; i >=0 ; i--) {
      if(list1.contains(list2.get(i))) {
        list2.remove(i);
      }
    }
    print(list1, list2);
  }
  
  static void print(ArrayList list1, ArrayList list2) {
    System.out.println("list1:" + list1);
    System.out.println("list2:" + list2);
    System.out.println();
  }
}
