package old.week1.stack;
/*
Node 클래스 정의
old.week1.stack interface 정의
LinkedListStack 정의
 */
class Node<E> {
  E data;
  Node<E> link;
}

interface StackIF<T> {
  boolean isEmpty();
  void push(T element);
  T pop();
  T peek();
  int size();
}

public class LinkedListStack<T> implements StackIF<T>{

  Node<T> top = new Node<>();

  @Override
  public boolean isEmpty() {
    return (top == null) ? true : false;
  }

  @Override
  public void push(T element) {
    Node<T> newNode = new Node<>();
    newNode.data = element;
    newNode.link = top;
    top = newNode;
  }

  @Override
  public T pop() {
    T data = top.data;
    top = top.link; //현재 top 을 링크드리스트에서 제거
    return data;
  }

  @Override
  public T peek() {

    return top.data;
  }

  @Override
  public int size() {
    int count = 0;
    Node<T> current = top; 
    /*
    top을 직접 사용하지 않고, current를 사용해 순회 (top을 직접 사용하면 old.week1.stack 파괴, java.lang.NullPointerException: Cannot read field "link" because "this.top" is null)
    top을 new Node<>()로 초기화했기 때문입니다. new Node<>()는 새로운 Node 객체를 생성하므로, 이 객체는 null이 아님 ->  count - 1 해줘야함
    */while (current != null) {
      count++;
      current = current.link;
    }
    return count - 1;
  }

  public static void main(String[] args) {
    LinkedListStack<String> stack = new LinkedListStack<>();

    //peek
    System.out.println(stack.peek());//null
    //push
    stack.push("hello");
    stack.push("mugthing");
    stack.push("amsterdam");
    stack.push("raon");
    stack.push("z flip");
    //popcv
    System.out.println(stack.size());//5
    System.out.println(stack.pop());//z flip
    System.out.println(stack.size());//4
  }
}
