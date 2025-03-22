import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
  static BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder s = new StringBuilder();
  public static void main(String [] args) throws Exception{
    int n = Integer.parseInt(bu.readLine());

    for (int i = 0 ; i < n ; i++){
      Stack<String> stack = new Stack<>();
      String [] arr = bu.readLine().split("");

      int exception = 0;
      int j = 0;
      while (j < arr.length){
        if (arr[j].equals("("))
          stack.push(arr[j]);
        else
          if (!stack.isEmpty())
            stack.pop();
          else {
            exception = 1;
            break;
          }
        j++;
      }
      if (stack.isEmpty() && exception == 0)
        s.append("YES\n");
      else if(!stack.isEmpty() || exception == 1)
        s.append("NO\n");


    }
    System.out.print(s);

  }
}