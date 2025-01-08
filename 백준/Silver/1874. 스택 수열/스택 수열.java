import java.util.*;
import java.io.*;

public class Main {
  static int n;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    n = Integer.parseInt(bf.readLine());
    Stack<Integer> stack = new Stack<>();
    int start = 0;
    while(n-- >0 ){
      int value = Integer.parseInt(bf.readLine());
      if (value > start){
        for (int i = start+1; i <= value; i++){
          stack.push(i);
          sb.append("+\n");

        }
        start = value;
      }
      //value <= start 인 경우
      else if (stack.peek() != value){
        System.out.println("NO");
        return;
      }
      stack.pop();
      sb.append("-\n");
    }
    System.out.println(sb);
    return;
  }

}
