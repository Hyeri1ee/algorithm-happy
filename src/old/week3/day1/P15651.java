package old.week3.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15651 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int arr[];
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    arr = new int[m];

    int depth = 0;

    dfs(n,m,depth);
    System.out.println(sb);
  }

  public static void dfs(int n, int m, int depth){
    if (m == depth){//길이 m의 수열을 완성했음
      for (int num : arr){
        sb.append(num).append(" ");
      }
      sb.append("\n");
      return;
    }
    for (int i= 0 ; i <n; i++){
      arr[depth] = i+1;
      dfs(n,m,depth+1);
    }
  }

}
