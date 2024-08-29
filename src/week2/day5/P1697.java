package week2.day5;
import java.util.*;
import java.io.*;

public class P1697 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int visited[];

  public static void main(String[] args) throws Exception {
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    visited = new int[100001];
    if (n == k)
      System.out.println(0);
    else
      System.out.println(bfs(n, k));
  }

  private static int bfs(int n, int k) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(n);
    visited[n] = 1; //방문 체크

    int result = 0;
    while (!q.isEmpty()) {
      int front = q.poll();

      for (int i = 0; i < 3; i++) {
        int next;
        if (i == 0) {
          next = front + 1;
        } else if (i == 1) {
          next = front - 1;
        } else {
          next = front * 2;
        }
        //목표값 k와 같은지 확인
        if (next == k) {
          return visited[front];
        }
        if (next >= 0 && next < visited.length && visited[next] == 0) {
          q.add(next);
          visited[next] = visited[front] + 1;
        }
      }
    }
    return -1;

  }
}
