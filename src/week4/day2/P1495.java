package week4.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1495 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int answer;
  static int[] volume;
  static int[] dp;
  static int N, S,M;
  static ArrayList<Integer> list = new ArrayList<>();
  public static void main(String[] args) throws  Exception{
    StringTokenizer st =  new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken()); //곡의 개수
    S = Integer.parseInt(st.nextToken()); //시작 볼륨
    M = Integer.parseInt(st.nextToken()); //최대 볼륨
    volume = new int[N+1];
    dp = new int[M+1];

    st = new StringTokenizer(bf.readLine());
    for (int i = 0 ; i < N; i++){
      volume[i] = Integer.parseInt(st.nextToken());
    }

    executeByBottomUp();
  }

  static void executeByBottomUp(){

    Arrays.fill(dp, -1);
    dp[S] = 0;
    int result = -1;

    for(int n=1; n<=N; n++){
      List<Integer> change = new ArrayList<>();
      for(int m=0; m<=M; m++){
        if(dp[m]==n-1){
          int plus = m+volume[n];
          int minus = m-volume[n];

          if(plus<=M) change.add(plus);
          if(minus>=0) change.add(minus);

        }
      }

      for(int i=0; i<change.size(); i++){
        int change_idx = change.get(i);
        dp[change_idx] = n;
        if(n==N) result = Math.max(result, change_idx);
      }
    }
    System.out.println(result);
  }

}
