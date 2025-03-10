package old.week2.day1.DFS;
import java.util.*;
import java.io.*;

public class DFS_List {

  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken()); //노드 개수
    int m = Integer.parseInt(st.nextToken()); //간선 개수
    int v = Integer.parseInt(st.nextToken()); //시작 정점

    LinkedList<Integer> [] edge = new LinkedList[n+1];//연결 리스트를 이용한 간선 저장 2차 배열
    for (int i = 1; i <= n; i++) {//초기화!!!
      edge[i] = new LinkedList<>();
    }
    boolean [] visited = new boolean[n+1];

    for (int i = 0 ; i < m ;i++){
      st = new StringTokenizer(bf.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());

      edge[v1].add(v2);
      edge[v2].add(v1);
    }
    for (int i = 1; i <= n; i++) {//오름차순으로 정렬
      Collections.sort(edge[i]);
    }

    dfs1(edge,visited,v); //재귀로 구현한 dfs
    sb.append("\n\n");
    dfs2(n,edge,visited,v); //스택으로 구현한 dfs

  }

  private static void dfs2(int n, LinkedList<Integer>[] edge,boolean[] visited, int v) {
    Stack<Integer> stack = new Stack<>();

    stack.push(v);
    //시작 노드 방문처리
    visited[v] = true;
    //스택이 비어있지 않으면 계속 반복
    while(!stack.isEmpty()){
      int popped = stack.pop();
      //방문 노드 출력
      sb.append(popped + " ");

      //꺼낸 노드와 인접한 노드 찾기
      for (int node : edge[popped]){//for 문이 백트래킹을 구현해줌
        //인접한 노드 중 방문하지 않은 경우에 스택에 넣고 방문처리
        if (!visited[node])
        {
          stack.push(node);
          visited[node] = true;
        }
      }//for 문 종료후 방문 노드 출력은 해당 노드가 leaf일때 || 방문하지 않은 노드가 없을때
    }

  }

  private static void dfs1(LinkedList<Integer>[] edge, boolean[] visited,int v) {
    visited[v] = true;
    sb.append(v + " ");
    //방문한 노드에서 인접 노드 찾기
    for (int node : edge[v]){
      if (!visited[node])
        dfs1(edge,visited,node);
    }
  }
}
