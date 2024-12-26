package old.week3.day5;

import java.util.*;
import java.io.*;

public class P1759 {
  static int L, C;
  static ArrayList<String> alphabet = new ArrayList<>();
  static boolean[] visited;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static LinkedHashSet<String> ls = new LinkedHashSet<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(bf.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    visited = new boolean[C];

    st = new StringTokenizer(bf.readLine());
    for (int i = 0; i < C; i++) {
      alphabet.add(st.nextToken());
    }
    Collections.sort(alphabet);
    dfs(0, 0, 0, 0, "");
    for (String result : ls) {
      sb.append(result).append("\n");
    }

    // 출력
    System.out.println(sb.toString());
  }

  private static void dfs(int index, int Mcount, int Jcount, int currentLength, String currentWord) {
    if (currentLength == L) {
      if (Mcount >= 1 && Jcount >= 2) {
        ls.add(currentWord);
      }

      return;
    }

    // 주어진 범위 내에서 문자 탐색
    for (int i = index; i < C; i++) {
      if (!visited[i]) {
        visited[i] = true;
        String one = alphabet.get(i);

        // 1. 현재 문자를 선택하는 경우
        if (isM(one)) { // 모음인 경우
          dfs(i + 1, Mcount + 1, Jcount, currentLength + 1, currentWord + one);
        } else { // 자음인 경우
          dfs(i + 1, Mcount, Jcount + 1, currentLength + 1, currentWord + one);
        }

        // 2. 현재 문자를 선택하지 않는 경우도 추가
        dfs(i + 1, Mcount, Jcount, currentLength, currentWord);

        visited[i] = false; // 상태 복구
      }
    }
  }

  private static boolean isM(String d) {
    return "aeiou".contains(d);
  }
}
