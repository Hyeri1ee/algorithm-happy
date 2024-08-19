package week1.queue;

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
