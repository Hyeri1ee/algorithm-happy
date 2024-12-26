package 알고리즘_코딩테스트.old.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874_스택수열 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] sequence = new int[n];
    for (int i = 0; i < n; i++) {
      sequence[i] = Integer.parseInt(br.readLine());
    }

    StringBuilder result = new StringBuilder();
    Stack<Integer> stack = new Stack<>();

    int current = 1;  // 현재 push할 숫자
    boolean possible = true;

    for (int target : sequence) {
      // target을 만들기 위해 필요한 push 연산
      while (current <= target) {
        stack.push(current);
        result.append("+\n");
        current++;
      }

      // target이 스택의 top에 있는지 확인
      if (!stack.isEmpty() && stack.peek() == target) {
        stack.pop();
        result.append("-\n");
      } else {
        // target을 만들 수 없는 경우
        possible = false;
        break;
      }
    }

    // 결과 출력
    System.out.println(possible ? result : "NO");
  }
//  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//  static int n;
//  static int[] arr;
//  static StringBuilder result = new StringBuilder();
//
//  private static void input() throws IOException {
//    StringTokenizer st = new StringTokenizer(br.readLine());
//
//    n = Integer.parseInt(st.nextToken());
//    arr = new int[n];
//    for (int i = 0 ; i < n; i++){
//      st = new StringTokenizer(br.readLine());
//      arr[i] = Integer.parseInt(st.nextToken());
//    }//end of input
//  }
//
//  //스택으로 만들 수 있는 수열인지 판별하는 함수
//  private static StringBuilder validate(){
//    LinkedList<Integer> stack = new LinkedList<>();
//    initializeList(stack);
//    int curNumIndex = 0;//현재 스택의 마지막 인덱스 값 ( 0 은 초기 )
//    int numIndex = 0;//현재 stack에서 뽑아내려는 값 = arr[numIndex]
//    result.append("+\n");
//    while(numIndex < n){
//      if (stack.get(curNumIndex) < arr[numIndex]){
//        result.append("+\n");
//        curNumIndex++;
//      }else if (stack.get(curNumIndex) == arr[numIndex]) {
//        stack.remove(curNumIndex--);//stack에서 curNum 없애기
//        if (curNumIndex < 0){
//          curNumIndex = 0;
//          result.append("+\n");
//        }
//        result.append("-\n");
//        numIndex++; //뽑아내려는 값 갱신
//      }else if (stack.get(curNumIndex) > arr[numIndex]){
//        stack.remove(curNumIndex--);
//        result.append("-\n");
//      }
//    }
//    return result;
//
//  }
//
//
//
//  private static void initializeList(LinkedList<Integer> stack) {
//    for (int i = 0 ; i < n; i++){
//      stack.add(i+1);
//    }
//  }
//
//  public static void main(String[] args) throws IOException {
//    input();
//    result.append(validate());
//    System.out.println(result);
//
//  }
}
