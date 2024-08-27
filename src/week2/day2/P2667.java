package week2.day2;

import java.util.*;
import java.io.*;

public class P2667{
  static ArrayList<Integer> list = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();
  static int [][] nodes;
  static boolean[][] visited;
  static int n;
  static int[] dx = {0,0,-1,1};
  static int[] dy = {-1,1,0,0};

  public static void main(String [] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());

    nodes = new int[n+1][n+1];
    visited = new boolean[n+1][n+1];

    for (int i = 0 ; i <= n ;i++){//초기화
      nodes[i] =  new int[n+1];
      visited[i] = new boolean[n+1];
    }

    //노드 값 넣기
    for(int i = 1 ; i <= n; i++){
      String str = bf.readLine();
      for(int j =1 ;j <= n; j++){
        nodes[i][j]=str.charAt(j-1)-'0';//string 의 요소 각각을 int로 변환하는 방법
      }
    }
    int cnt = 0; //집 전체 개수
    for (int i = 1; i <= n ; i++){
      for (int j =1;j <=n ;j++){
        if (nodes[i][j]==1 && !visited[i][j])
        {
          int result = dfs(i,j);
          list.add(result);//집 1단체의 개수
          cnt++;
        }
      }
    }
    System.out.println(cnt);
    //list 오름차순 정렬
    Collections.sort(list);

    for(int i = 0 ; i < list.size(); i++)
      sb.append(list.get(i) + "\n");
    System.out.print(sb);

  }

  public static int dfs(int i, int j){
    int result = 0;

    visited[i][j] = true;
    result++;
    for (int k = 0 ; k < 4; k++){
      int nx = dx[k]+i;
      int ny = dy[k]+j;

      if (nx>=1 && ny>=1 && nx<=n && ny<=n && !visited[nx][ny] && nodes[nx][ny] == 1)
      {
        result += dfs(nx,ny);//dfs 의 결과 합산
      }
    }
    return result;

  }
}