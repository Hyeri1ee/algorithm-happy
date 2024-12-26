package old.week1.stack;

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
      System.out.println("old.week1.stack is full");
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
    customStack.push(1233);//old.week1.stack is full
    //peek
    System.out.println(customStack.peek()); //90
    System.out.println(customStack.size); //5
    //pop
    System.out.println(customStack.pop()); //90
    System.out.println(customStack.size); //4
  }
}
