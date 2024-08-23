package week1.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class P9093 {
  public static void main(String[] args) throws Exception {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(bf.readLine().trim()); // 공백 제거 후 변환

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(bf.readLine());

      while (st.hasMoreTokens()) {
        Stack<Character> insideStack = new Stack<>();
        String word = st.nextToken();

        // 스택에 각 문자의 문자 하나씩 넣기
        for (char c : word.toCharArray()) {
          insideStack.push(c);
        }

        // 스택에서 하나씩 꺼내서 단어 역순으로 만들기
        while (!insideStack.isEmpty()) {
          sb.append(insideStack.pop());
        }
        sb.append(" ");
      }
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
