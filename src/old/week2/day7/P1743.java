package old.week2.day7;

/*
1000
0110
1100

4
*/

import java.util.*;
import java.io.*;

public class P1743{
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int [][] node;

  static int[] dx = {0,0,1,-1};
  static int[] dy = {1,-1,0,0};

  static int n, m;

  public static void main(String [] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int k  = Integer.parseInt(st.nextToken());

    node = new int[n+1][m+1];
    for (int i = 0 ; i <= n ;i++){
      node[i] = new int[m+1];
    }

    for (int i=0;i<k;i++)//node 초기화
    {
      st = new StringTokenizer(bf.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      node[a][b] = 1;

    }
    Set<Integer> arr= new HashSet<>();//dfs 뭉치들 크기 저장할 set
    int[] v;
    for (int i = 1 ; i <= n;i++){
      for (int j=1; j<= m; j++){
        v = new int [] {i,j};
        if (node[i][j] == 1){
          arr.add(dfs(v));
        }
      }
    }

    //arr 에서 중복부분 제거
    List list = new LinkedList(arr); // LinkedList(Collection c), set의 요소들을 List에 저장
    Collections.sort(list); // Collections.sort(), list를 정렬
    System.out.println(list.get(list.size()-1)); // list를 출력

  }

  public static int dfs(int [] v){//dfs로 탐색하되, 방문한 node 값은 2로 바꾸기
    Stack<int[]> stack = new Stack<>();
    int result = 1;
    stack.push(v);
    node[v[0]][v[1]] = 2;
    while(!stack.isEmpty()){
      int[] top = stack.peek();
      boolean flag = false;
      for (int i = 0 ; i < 4; i++){
        int x = dx[i] + top[0]; int y = dy[i]+top[1];
        if (x >= 0 && x <= n && y >= 0 && y<= m && node[x][y] ==1){
          result++;
          flag = true;
          stack.push(new int[] {x,y});
          node[x][y] =2;
          break;
        }
      }
      if (flag == false)
        stack.pop();
    }
    return result;
  }
}