package week2.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_2 {
  static StringBuilder sb = new StringBuilder();
  static boolean[] visited;
  static LinkedList<Integer>[] edge;//인접리스트로 구현
  static int n, m, v;
  static Queue<Integer> queue = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());

    //방문 여부 visited 배열 초기화
    visited = new boolean[n + 1];//n+1을 해주는 이유 : 인덱스 값 = 정점의 수 를 동일시하기 위해서
    //간선 인접리스트 초기화 후 값 받기
    //초기화
    for (int i = 0; i < n + 1; i++) {
      edge[i] = new LinkedList<>();
    }

    dfs(v);
    sb.append("\n");
    bfs(v);
  }

  private static void dfs(int v) {
    Stack<Integer> stack = new Stack<>();

    stack.push(v);
    //시작 노드 방문처리
    visited[v] = true;
    //스택이 비어있지 않으면 계속 반복
    while (!stack.isEmpty()) {
      int popped = stack.pop();
      //방문 노드 출력
      sb.append(popped + " ");

      //꺼낸 노드와 인접한 노드 찾기
      for (int node : edge[popped]) {//for 문이 백트래킹을 구현해줌
        //인접한 노드 중 방문하지 않은 경우에 스택에 넣고 방문처리
        if (!visited[node]) {
          stack.push(node);
          visited[node] = true;
        }
      }//for 문 종료후 방문 노드 출력은 해당 노드가 leaf일때 || 방문하지 않은 노드가 없을때
    }
  }

  private static void bfs(int v) {
    Queue<Integer> queue = new LinkedList<>();
    visited[v] = true;
    queue.offer(v);

    while (queue.size() != 0) {
      v = queue.poll();
      System.out.print(v + " ");

      Iterator<Integer> iter = edge[v].listIterator();
      while (iter.hasNext()) {
        int w = iter.next();
        if (!visited[w]) {
          visited[w] = true;
          queue.add(w);
        }
      }
    }
  }
}
