package 알고리즘_코딩테스트.dayone.apr01;

import java.util.*;
import java.io.*;

public class BOJ_15990 {
    static int T;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[100001][4];

        dp[1][2] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        /*
        5를 만드는 방법
        4 -> 4를 만드는 방법 + 1
        3 -> 3을 만드는 방법 + 2
        2 -> 2를 만드는 방법 + 1
         */
        for(int i = 4; i < 100001; i++){
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i-3][2] + dp[i-3][1]) % 1_000_000_009;

        }

        //dp를 먼저 정의한 후

        while(T-- > 0){
            int n = sc.nextInt();
            sb.append( (dp[n][1] + dp[n][2] + dp[n][3])  % 1_000_000_009).append("\n");
        }

        System.out.println(sb);
    }
}
