package week2.day1;

import java.util.*;
import java.io.*;

public class P1260_other{
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  static Stack<Integer> stack = new Stack();
  static Queue<Integer> queue = new LinkedList<>();
  public static void  main (String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(bf.readLine()," ");
    int n = Integer.parseInt(st.nextToken());//정점 개수
    int m = Integer.parseInt(st.nextToken());//간선 개수
    int v = Integer.parseInt(st.nextToken());//시작 정점

    LinkedList<Integer>[] graph = new LinkedList[n+1];
    boolean[] visited1 = new boolean[n+1];
    boolean[] visited2 = new boolean[n+1];

    //런타임 에러 (graph 초기화)
    for (int i = 1; i <= n; i++) {
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < m ; i++){
      st = new StringTokenizer(bf.readLine()," ");
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      graph[v1].add(v2);
      graph[v2].add(v1);
    }

    // 방문 순서를 위해 오름차순 정렬 : 점점이 가장 작은 것 부터 봄
    for (int i = 1; i <= n; i++) {
      Collections.sort(graph[i]);
    }

    //dfs 결과
    stack.push(v);
    visited1[v] = true;

    //스택이 비어있지 않으면 계속 반복
    while(!stack.isEmpty()){
      int nodeIndex = stack.pop();
      visited1[nodeIndex] = true;
      sb.append(nodeIndex + " ");

      for (int LinkedNode : graph[nodeIndex]){
        if (!visited1[LinkedNode] && LinkedNode > 0){
          stack.push(LinkedNode);
          break;
        }
      }
    }
    sb.append("\n");

    //bfs 결과
    visited2[v] = true;
    queue.offer(v);

    while(!queue.isEmpty()){
      int nodeIndex = queue.poll();
      sb.append(nodeIndex +" ");

      for (int LinkedNode : graph[nodeIndex]){
        if (!visited2[LinkedNode] && LinkedNode >0 ){
          queue.offer(LinkedNode);
          visited2[LinkedNode] = true;
        }
      }
    }
    System.out.print(sb);




  }
}