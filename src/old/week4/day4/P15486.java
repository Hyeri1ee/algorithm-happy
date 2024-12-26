package old.week4.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15486 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int[][] schedule;
  static int[] dp;

  static int n;
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    dp = new int[n+1];
    schedule = new int[n+1][2];
    for (int i = 1 ; i <= n; i++){
      st = new StringTokenizer(bf.readLine());
      schedule[i][0] = Integer.parseInt(st.nextToken());//I날짜 상담의 소요일
      schedule[i][1] = Integer.parseInt(st.nextToken());//i날짜 금액 저장

    }// end of input

    for (int i =1; i <= n; i++){//첫날부터 마지막날까지
      int time = schedule[i][0], price = schedule[i][1];
      if (i + time - 1 <= n){//이전날 누적값에 오늘 상담을 더한 값이 퇴사 날 포함 전이면
        dp[i+time-1] = Math.max(dp[i+time-1], dp[i-1] + price);
      }

      dp[i] = Math.max(dp[i], dp[i-1]);
    }

    System.out.println(dp[n]);
  }
}
