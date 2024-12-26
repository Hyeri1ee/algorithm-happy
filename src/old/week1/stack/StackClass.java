package old.week1.stack;

import java.util.Random;
import java.util.Stack;

public class StackClass {
  public static void main(String[] args) {

    //난수 설정
    Random random = new Random();
    random.setSeed(System.currentTimeMillis());
    //old.week1.stack 생성
    Stack<Integer> stack = new Stack<>();
    for (int i = 0 ;  i < 10 ; i++){
      stack.push(random.nextInt(100) +1); //1~100 까지의 난수 중 무작위로 stack에 넣음
    }
    stack.push(111); //search 메서드 테스트를 위해서

    //old.week1.stack 메서드 실행
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