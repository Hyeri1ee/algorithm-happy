package week2.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//dfs - 재귀로 구현
public class P1260 {

  static StringBuilder sb = new StringBuilder();
  static boolean[] visited;
  static int[][] edge;

  static int n, m, v;

  static Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v= Integer.parseInt(st.nextToken());

    edge = new int[n+1][n+1]; //n+1을 해주는 이유 : 인덱스 값 = 정점의 수 를 동일시하기 위해서
    visited = new boolean[n+1];

    for(int i = 0 ; i < n ; i ++) {
      //공백을 기준으로 나누어 받는 값의 경우 아래 방식이 유용합. (ex. a   b)
      StringTokenizer str = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(str.nextToken());
      int b = Integer.parseInt(str.nextToken());

      edge[a][b] = edge[b][a] =  1;
    }

    dfs(v);
    sb.append("\n");
    visited = new boolean[n+1]; //새로운 visited 배열을 만들 필요 없이 기존 변수에 새로운 생성자 정의

    bfs(v);

    System.out.println(sb);

  }
  public static void dfs(int v) {

    visited[v] = true;
    sb.append(v + " ");

    for(int i = 0 ; i <= n ; i++) {
      if(edge[v][i] == 1 && !visited[i])
        dfs(i);//재귀로 구현
    }

  }

  public static void bfs(int v) {
    queue.offer(v);
    visited[v] = true;

    while(!queue.isEmpty()) {

      v = queue.poll();
      sb.append(v + " ");

      for(int i = 1 ; i <= n ; i++) {
        if(edge[v][i] == 1 && !visited[i]) {
          queue.offer(i);
          visited[i] = true;
        }
      }
    }


  }

}