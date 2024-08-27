package week2.day4;

import java.io.*;
import java.util.*;

public class P1012{
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int [] dx = {0,0,1,-1};
  static int [] dy = {1,-1,0,0};

  public static void main(String[] args) throws Exception{
    int T = Integer.parseInt(bf.readLine());
    while(T-- > 0){
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int m = Integer.parseInt(st.nextToken());//가로 길이
      int n = Integer.parseInt(st.nextToken());//세로 길이
      int k = Integer.parseInt(st.nextToken());//배추 위치 개수

      //초기화
      int [][] nod = new int[n][m];//세로 , 가로
      boolean [][] visited = new boolean[n][m];

      for (int i = 0 ; i < n; i++){
        nod[i] = new int[m];
        visited[i] = new boolean[m];
      }
      for (int j =0; j< k;j++){//배추 개수만큼 for문 반복
          st = new StringTokenizer(bf.readLine());
          int v1 = Integer.parseInt(st.nextToken());
          int v2 = Integer.parseInt(st.nextToken());

          nod[v2][v1] = 1;
      }



      int count = 0;
      for (int i= 0; i<n;i++){
        for (int j=0;j<m ;j++){
          if (!visited[i][j] && nod[i][j] ==1)
          {
            dfs(n,m,nod, visited, i,j);
            count++;
          }
        }
      }

      sb.append(Integer.toString(count)+"\n");


    }

    System.out.println(sb);

  }
  private static void dfs(int n, int m, int [][] nod, boolean [][] visited, int i, int j){//스택으로 구현해보기
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[] {i,j});
    visited[i][j] = true;
    while(!stack.isEmpty()){
      int[] top = stack.peek();
      boolean flag = false;
      for (int p=0; p<4;p++){//상하좌우 체크

        int x = dx[p]+top[0];//세로 좌표
        int y = dy[p]+top[1];//가로 좌표

        if (x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && nod[x][y] == 1)
        {
          visited[x][y] = true;
          stack.push(new int[] {x,y});
          flag = true;
          break;
        }
      }
      if (!flag)
        stack.pop();
    }
  }
}