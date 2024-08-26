package week2.day1;

import java.util.*;
import java.io.*;

public class P1260 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
    int n = Integer.parseInt(st.nextToken()); // 정점 개수
    int m = Integer.parseInt(st.nextToken()); // 간선 개수
    int v = Integer.parseInt(st.nextToken()); // 시작 정점

    LinkedList<Integer>[] graph = new LinkedList[n + 1];
    boolean[] visited1 = new boolean[n + 1];
    boolean[] visited2 = new boolean[n + 1];

    // 그래프 초기화
    for (int i = 1; i <= n; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine(), " ");
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph[v1].add(v2);
      graph[v2].add(v1);
    }

    // 방문 순서를 위해 오름차순 정렬
    for (int i = 1; i <= n; i++) {
      Collections.sort(graph[i]);
    }

    // DFS 결과
    dfsUsingStack(v, graph, visited1);
    sb.append("\n");

    // BFS 결과
    bfs(v, graph, visited2);

    System.out.print(sb);
  }

  // 스택을 이용한 DFS 함수
  private static void dfsUsingStack(int startNode, LinkedList<Integer>[] graph, boolean[] visited) {
    Stack<Integer> stack = new Stack<>();
    stack.push(startNode);
    visited[startNode] = true;

    while (!stack.isEmpty()) {
      int node = stack.pop();
      sb.append(node).append(" ");

      // 연결된 노드를 역순으로 스택에 넣어서 작은 것부터 처리되도록
      for (int i = graph[node].size() - 1; i >= 0; i--) {
        int nextNode = graph[node].get(i);
        if (!visited[nextNode]) {
          stack.push(nextNode);
          visited[nextNode] = true;
        }
      }
    }
  }

  // BFS 함수
  private static void bfs(int startNode, LinkedList<Integer>[] graph, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(startNode);
    visited[startNode] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      sb.append(node).append(" ");

      for (int nextNode : graph[node]) {
        if (!visited[nextNode]) {
          queue.offer(nextNode);
          visited[nextNode] = true;
        }
      }
    }
  }
}
