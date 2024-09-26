package week5.day1.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P19701 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int E,V; // 간선, 정점

  static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
  static boolean visited[];
  static int dist[];



  public static void main(String[] args) throws Exception {
    input();
  }

  private static void input() throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    visited = new boolean[V+1];
    dist = new int[V+1];

    for (int i = 0 ; i < V+1 ; i++)
    {
      st = new StringTokenizer(bf.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      //graph.get(a).add(new Node(b, t, k));
    }

  }

  class Node{
    private int dongas;
    private int idx;
    private int time;

    public Node(int idx, int time, int dongas){
      this.dongas = dongas;
      this.time = time;
      this.idx = idx;
    }
    public int getIdx(){
      return idx;
    }
    public int getTime(){
      return time;
    }
  }
}
