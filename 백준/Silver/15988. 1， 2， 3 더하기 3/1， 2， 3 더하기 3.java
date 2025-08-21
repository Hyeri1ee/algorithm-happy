
import java.util.*;

public class Main {
    static int t;
    static int n;
    static long[] dp;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int dividenum = 1_000_000_009;
        Scanner sc = new Scanner(System.in);
        //input
        t = sc.nextInt();
        arr = new int[t+1];
        int max = Integer.MIN_VALUE;
        for(int i =1 ; i <= t; i++)
        {
            arr[i] = sc.nextInt();
            if (max < arr[i])
                max = arr[i];
        }

        //init

        dp = new long[max+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] =  0  +  dp[0] +  dp[1]; // 이 다음 3추가 + 이 다음 2추가 + 이 다음 1추가 ///값 : 1
        dp[3] =  dp[0]  +  dp[1] +  dp[2]; // 이 다음 3추가 + 이 다음 2추가 + 이 다음 1추가
        //가장 큰 값 기준으로 한번 만들기
        long maxv = max;

          //solve
        if (max >= 4)
            for(int i = 4; i <= max; i++){
                dp[i] = (dp[i-1] % dividenum + dp[i-2]  % dividenum + dp[i-3] % dividenum) % dividenum;
        }



        //정답 구성
        for(int i = 1; i <= t; i++){
            sb.append(dp[arr[i]] + "\n");
        }


        System.out.println(sb);
    }
}
