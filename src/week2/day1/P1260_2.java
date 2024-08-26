package week2.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_2 {
  static StringBuilder sb = new StringBuilder();
  static boolean[] visited;
  static LinkedList<Integer>[] edge;// 인접리스트로 구현
  static int n, m, v;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());

    // 방문 여부 visited 배열 초기화
    visited = new boolean[n + 1];// n+1을 해주는 이유: 인덱스 값 = 정점의 수를 동일시하기 위해서
    // 간선 인접리스트 초기화 후 값 받기
    // 초기화
    edge = new LinkedList[n + 1];
    for (int i = 0; i <= n; i++) {
      edge[i] = new LinkedList<>();
    }

    for (int i = 0; i < m; i++) { // 간선 개수만큼 반복
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      edge[v1].add(v2);
      edge[v2].add(v1);
    }

    // 인접 리스트 정렬
    for (int i = 1; i <= n; i++) {
      Collections.sort(edge[i]);
    }

    // DFS 실행
    dfs(v);
    sb.append("\n");

    // BFS 전에 방문 배열 초기화
    visited = new boolean[n + 1];
    bfs(v);

    // 최종 출력
    System.out.println(sb);
  }

  private static void dfs(int v) {
    Stack<Integer> stack = new Stack<>();
    stack.push(v);
    visited[v] = true;

    while (!stack.isEmpty()) {
      int popped = stack.pop();
      sb.append(popped + " ");

      for (int node : edge[popped]) {
        if (!visited[node]) {
          stack.push(node);
          visited[node] = true;
        }
      }
    }
  }

  private static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    visited[v] = true;
    queue.offer(v);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      sb.append(node + " ");

      for (int neighbor : edge[node]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.add(neighbor);
        }
      }
    }
  }
}
