package old.week2.day1;

import java.util.*;
import java.io.*;

public class Practice1{
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int[][] e;
  static boolean[] visited;
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int v = Integer.parseInt(st.nextToken());

    e = new int[n+1][n+1];
    for (int i = 0  ; i < n+1 ; i++)
      e[i] = new int[n+1];
    visited = new boolean[n+1];

    for (int i = 0 ; i < m; i++){
      st = new StringTokenizer(bf.readLine());
      int v1= Integer.parseInt(st.nextToken());
      int v2= Integer.parseInt(st.nextToken());

      e[v1][v2] = 1;
      e[v2][v1] = 1;
    }


    dfs_recursive(n,v);//재귀
    Arrays.fill(visited,false); //배열 일괄 초기화
    sb.append("\n");
    dfs_stack(n,v);//스택
    sb.append("\n");
    Arrays.fill(visited,false); //배열 일괄 초기화
    bfs(n,v);

    System.out.println(sb);

  }

  private static void dfs_recursive(int n,int v){
    visited[v] = true;
    sb.append(v + " ");
    for (int i = 1; i <= n ; i++){
      if (!visited[i] && e[v][i] == 1){
        visited[i] = true;
        dfs_recursive(n,i);
      }
    }
  }

  private static void dfs_stack(int n, int v){
      Stack<Integer> stack = new Stack<>();
      stack.push(v);
      visited[v] = true;
      sb.append(v + " ");

    while(!stack.isEmpty()){
        int top = stack.peek();
        boolean flag = false;

        for (int i=1; i<= n; i++){
          if (!visited[i] && e[top][i] == 1){
            stack.push(i);
            visited[i] = true;
            flag = true;
            sb.append(i + " ");//위치이유 : 지금까지 가지 않은 노드이기 때문

            break;
          }
        }
        if (!flag) //flag == false
        {
          stack.pop();
        }
      }
  }

  private static void bfs(int n,int v){
    Queue<Integer> que = new LinkedList<>();
    que.offer(v);
    visited[v] = true;
    while(!que.isEmpty()){
      int front = que.poll();
      sb.append(front +" ");

      for (int i = 1 ; i <= n; i++){
        if (!visited[i] && e[front][i] == 1){
          visited[i] = true;
          que.offer(i);
        }
      }
    }


  }
}