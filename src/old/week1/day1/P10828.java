package old.week1.day1;

import java.io.*;
import java.util.*;

public class P10828 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < N; i++) {
      String[] command = br.readLine().split(" ");

      switch (command[0]) {
        case "push":
          stack.push(Integer.parseInt(command[1]));
          break;
        case "pop":
          if (stack.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(stack.pop()).append("\n");
          }
          break;
        case "size":
          sb.append(stack.size()).append("\n");
          break;
        case "empty":
          sb.append(stack.isEmpty() ? 1 : 0).append("\n");
          break;
        case "top":
          if (stack.isEmpty()) {
            sb.append("-1\n");
          } else {
            sb.append(stack.peek()).append("\n");
          }
          break;
      }
    }

    System.out.print(sb.toString());
  }
}
