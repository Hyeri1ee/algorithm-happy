package old.week5.day1.최단경로;

import java.util.*;
import java.io.*;

class P1446 {
  static int N, D;
  static List<List<Node>> graph = new ArrayList<>();
  static int[] distance;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    D = Integer.parseInt(st.nextToken());
    for (int i = 0; i <= 10001; i++)
      graph.add(new ArrayList<>());
    distance = new int[10001];
    for (int i = 0; i < distance.length; i++) distance[i] = i; //정석대로 갈 때 i만큼 이동해서 가기때문

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      graph.get(a).add(new Node(b, w));
    }//end of input

    dijkstra(0);

    System.out.println(distance[D]);//D에 도착했을 때 최종적으로 간 거리
  }

  static void dijkstra(int start) {
    if (start > D) return;

    if (distance[start + 1] > distance[start] + 1) distance[start + 1] = distance[start] + 1;//정석

    for (int i = 0; i < graph.get(start).size(); i++) {
      if (distance[start] + graph.get(start).get(i).weight < distance[graph.get(start).get(i).node])
        distance[graph.get(start).get(i).node] = distance[start] + graph.get(start).get(i).weight;
    }
    /*
    distance[start] = start까지 온 거리
    if 조건문 : start 부터 i까지 지름길로 갔을 때의 거리 vs i까지 정석대로 갔을 때의 거리
    갱신

     */

    dijkstra(start + 1);//start+1까지 온 거리
  }

  static class Node {
    int node;
    int weight;

    Node(int node, int weight) {
      this.node = node;
      this.weight = weight;
    }
  }
}