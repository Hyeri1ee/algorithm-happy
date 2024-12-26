package old.week2.day1.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BFS_List {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(bf.readLine()); //정점의 개수
    int m = Integer.parseInt(bf.readLine()); //간선의 개수
    int v = Integer.parseInt(bf.readLine()); //탐색을 시작할 정점의 번호

    boolean visited[] = new boolean[n + 1]; //방문 여부를 검사할 배열

    LinkedList<Integer>[] adjList = new LinkedList[n + 1];

    for (int i = 0; i <= n; i++) {
      adjList[i] = new LinkedList<Integer>();
    }

    // 간선 정보 입력
    for (int i = 0; i < m; i++) {
      String[] edge = bf.readLine().split(" ");
      int v1 = Integer.parseInt(edge[0]);
      int v2 = Integer.parseInt(edge[1]);
      adjList[v1].add(v2);
      adjList[v2].add(v1);
    }

    // 방문 순서를 위해 오름차순 정렬
    for (int i = 1; i <= n; i++) {
      Collections.sort(adjList[i]);
    }

    System.out.println("BFS-인접리스트");
    BFS_list(v, adjList, visited);
  }

  // BFS-인접리스트
  public static void BFS_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    visited[v] = true;
    queue.offer(v);

    while(queue.size() != 0) {
      v = queue.poll();
      System.out.print(v + " ");

      Iterator<Integer> iter = adjList[v].listIterator();
      while(iter.hasNext()) {
        int w = iter.next();
        if(!visited[w]) {
          visited[w] = true;
          queue.add(w);
        }
      }
    }
  }
}
