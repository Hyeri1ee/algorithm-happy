import java.io.*;
import java.util.*;

public class Main {
    static int d, n;
    static long m;
    static long[][] dp;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        d = Integer.parseInt(sc.next());
        m = Integer.parseInt(sc.next());
        n = d/2;
        dp = new long[d+1][n+1];

        /*
        d 는 짝수
        d/2 가 홀수이면 1, 3, 5, .... d/2 까지 도달하는 경우의 수
        d/2가 짝수이면 2,4, 6, 8 ...    d/2까지 도달하는 경우의 수

        dp[i][h] : i번째 이동후 높이가 h인 경우수
         */
        dp[0][0] = 1;

        for(int i = 1; i <= d; i++){
            for(int h = 0 ; h < n+1; h++){
                dp[i][h] = 0;
                if (h > 0)
                {
                    dp[i][h] += dp[i-1][h-1];
                    dp[i][h] %= m;
                }
                if (h < n)
                {
                    dp[i][h] += dp[i-1][h+1];
                    dp[i][h] %= m;
                }

                if(h == 0 && i < d)
                {
                    dp[i][h] = 0;
                }

            }
        }

        System.out.println(dp[d][0] %= m);






    }
}
