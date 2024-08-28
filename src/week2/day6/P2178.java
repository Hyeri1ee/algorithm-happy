package week2.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int [][] node;
  static int[][] answer;
  static int n,m,count;
  
  static int[] dx = {0,0,1,-1};
  static int[] dy = {1,-1,0,0};
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    node = new int[n+1][m+1];
    answer = new int[n+1][m+1];

    for (int i = 0 ; i <= n; i++){
      node[i] = new int[m+1];
      answer[i] = new int[m+1];
    }
    for (int i =1 ; i<= n; i++){//배열 입력 초기화
      char[] c = bf.readLine().toCharArray();
      for (int j=1; j<=m;j++){
        node[i][j] = c[j-1] - '0';

      }
    }
    count = bfs(1,1);
    System.out.println(count);
  }
  
  public static int bfs(int a, int b){//node[a,b]에서 시작해서 node[n,m]까지 가는 최소 칸 수 구하기
    Queue<int[]> que = new LinkedList<>();
    que.offer(new int[] {a,b});
    answer[a][b] = 1;//방문 체크
    while(!que.isEmpty()){
      int[] front = que.poll();

      for (int i = 0 ;i <4;i++){
        int ax = front[0]+ dx[i];
        int bx = front[1]+dy[i];

        if (ax>=0 && ax <= n && bx >= 0 && bx <= m && answer[ax][bx] == 0 && node[ax][bx] == 1){
          answer[ax][bx] = 1 + answer[front[0]][front[1]];
          que.offer(new int[] {ax,bx});
        }

        //node[n][m] 도착 확인
        if (answer[n][m] > 0)
          break;
      }
    }
    return answer[n][m];
  }
}
