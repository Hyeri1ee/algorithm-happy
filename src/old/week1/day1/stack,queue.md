<aside>
🍏 개념과제

: 스택/큐 개념 정리 및 구현코드 작성

</aside>

> 스택(stack)

- stack 클래스, 메서드

  LIFO(Last In First Out) 후입선출 구조, 단방향 입출력 구조, 깊이 우선 탐색에 이용.

  자바는 java.util.Stack  클래스를 통해 stack 을 제공한다.

  | method | detail                                                                                          |
      | --- |-------------------------------------------------------------------------------------------------|
  | boolean empty() | stack이 비어있는지 확인                                                                                 |
  | Object peek() | stack의 맨 위 객체 반환<br><strong>pop과 달리 stack에서 객체 꺼내지 않음</strong><br>비어있는 경우 EmptyStackException 발생 |
  | Object pop() | stack의 맨 위 객체 꺼냄<br>비어있는 경우 EmptyStackException 발생
  | Object push(Object iem) | stack에 객체(item) 저장                                                                              |
  | int search(Obect o) | stack에서 주어진 객체 o를 찾아서 그 위치 반환 <br>못 찾은 경우 -1 반환<br>위치(인덱스가 빠져나오는 순서)는 1부터 시작     |                                                              


```java
import java.util.Random;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {

    //난수 설정
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    //stack 생성
    Stack<Integer> stack = new Stack<>();
    for (int i = 0 ;  i < 10 ; i++){
      stack.push(random.nextInt(100) +1); //1~100 까지의 난수 중 무작위로 stack에 넣음
    }
    stack.push(111); //search 메서드 테스트를 위해서

    //stack 메서드 실행
    //empty()
    System.out.println(stack.empty()); //fasle
    //peek(), pop()
    System.out.println(stack.peek()); //111
    System.out.println(stack.pop()); //111
    stack.push(111);
    System.out.println(stack.size()); //11
    //search()
    System.out.println(stack.search(111)); //10
  }
}
```

> stack 자체 구현
>> 배열로 stack 구현

```java
package stack;

public class StackArray {
  int top; //인덱스
  int size; //스택 배열 크기
  int [] stack;

  //스택 생성자
  public StackArray(int size){
    this.size = size;
    stack = new int[size];
    top = -1;
  }

  //스택 메서드
  public void push(int e){
    if (top == size -1){
      System.out.println("stack is full");
      return;
    }
    stack[++top] = e;
    System.out.println("pushed " + stack[top]);
    return;
  }

  public int peek(){
    if (top == -1)
      return -1;
    return stack[top];
  }

  public int pop(){
    if (top == -1)
      return -1;
    size--; //사이즈 줄이기
    return stack[top--]; //top 인덱스 줄이기
  }

  public boolean isEmpty(){
    if (top == -1)
     return true;
    else
      return false;
  }

  //테스트
  public static void main(String[] args) {
    StackArray customStack = new StackArray(5);
    //peek
    System.out.println(customStack.peek());
    //push
    customStack.push(12);
    customStack.push(112);
    customStack.push(9);
    customStack.push(44);
    customStack.push(90);
    customStack.push(1233);//stack is full
    //peek
    System.out.println(customStack.peek()); //90
    System.out.println(customStack.size); //5
    //pop
    System.out.println(customStack.pop()); //90
    System.out.println(customStack.size); //4
  }
}

```
>> LinkedList 로 stack 구현

```java
package stack;
/*
Node 클래스 정의
stack interface 정의
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
    top을 직접 사용하지 않고, current를 사용해 순회 (top을 직접 사용하면 stack 파괴, java.lang.NullPointerException: Cannot read field "link" because "this.top" is null)
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

```
<details>
<summary>출처</summary>
<div markdown="1">

[[Java] 자바 스택(Stack) 클래스 메서드 정리 및 활용](https://ittrue.tistory.com/200)

[[자료구조] 연결리스트를 이용해 스택 구현하기 / Java, Stack, LinkedList(단방향)](https://foreveryoung97.tistory.com/104)

[🧱 자바 Stack 구조 & 사용법 정리](https://inpa.tistory.com/entry/JCF-🧱-Stack-구조-사용법-정리#stack_클래스는_deprecated_되었다)

[[자료구조] 스택(Stack) 자료구조 알아보기 & Java 예제 코드](https://hoehen-flug.tistory.com/30)

</div>
</details>


> 큐(Queue)
>
- queue 클래스, 메서드

  FIFO(First In First Out) 선입출 구조, BFS 탐색에서 사용

  ![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/85786b23-4d04-4e4c-bb8c-14f0ddf89a8f/79d17295-979a-4a5a-9cf5-540786ecc5e7/image.png)

  | 메서드 | 반환 타입                                                                        | 설명                                                                                   |
      | --- |------------------------------------------------------------------------------|--------------------------------------------------------------------------------------|
  | offer(E e) | boolean                                                                      | 주어진 객체 삽입(enqueue).<br> 성공 시 true, 실패 시 false 반환                                     |
  | add(E e) | boolean<br/>Exception                                                        | 주어진 객체 삽입(enqueue).<br>성공 시 true, 실패 시 Exception.                                    |
  | peek() | E                               <Br>null                                     | head에 위치한 객체 리턴.                <br>큐가 비었다면 null 반환                                  |
  | element() | E                                        <br>Exception                       | 큐의 head 리턴.                              <br>큐가 비었다면 Exception                       |
  | poll() | E                                                      <br>Exceptio          | front에 위치한 객체 리턴 후 제거(dequeue).                        <br>큐가 비었다면 null 반환           |
  | remove(E e) | E                                                                   <br>null | 특정 객체 E 제거                                                          <br>큐가 비었다면 null |

    ```java
    package queue;
    
    import java.util.LinkedList;
    import java.util.Queue;
    
    public class QueueClass {
      public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("h");
        queue.offer("a");
        queue.offer("k");
    
        System.out.println(queue.peek()); //k
        System.out.println(queue.size()); //3
        System.out.println(queue.poll());//h
        System.out.println(queue.size()); //2
    
      }
    }
    
    ```

>queue 자체 구현 
>> 배열로 queue 구현

```java
package queue;

public class QueueArray {
  int MAX = 1000;
  int front; int rear; //참조하는 index
  /*
  front:맨 앞 요소의 인덱스
  rear: 맨 뒤 요소의 다음 인덱스
   */
  int [] queue;
  public QueueArray(){
    front = rear = 0; //초기값
    queue = new int[MAX];
  }
  public boolean queueisEmpty(){
    return front == rear;
  }
  public boolean queueisFull() {
    if(rear == MAX-1) {
      return true;
    }else
      return false;
  }
  public int size(){
    return rear - front;
  }

  public void push(int value){
    if (queueisFull()){
      System.out.println("Queue is full");
      return;
    }
    queue[rear++] = value;
  }
  public int pop(){
    if (queueisEmpty()){
      System.out.println("Queue is empty");
    }
    int popvalue = queue[front++];
    return popvalue;
  }

  public static void main(String[] args) {
    QueueArray que = new QueueArray();
    que.push(3);
    que.push(10);
    que.push(30);
    que.push(55);
    que.push(11);
    System.out.println(que.size()); //5
    System.out.println(
            que.pop()
    ); //3
    System.out.println(que.size()); //4
  }
}

```

<details>
<summary>출처</summary>
<div markdown="1">

[[자료구조/Java] Queue (Java구현, 관련 메소드)](https://93jpark.tistory.com/103)

[[자료구조] JAVA로 큐(Queue)구현](https://go-coding.tistory.com/6)

</div>
</details>