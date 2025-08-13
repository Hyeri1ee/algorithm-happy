

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();

        //가장 큰 dp[i]수
        int answer = 0;
        for(int i : dp){
            if (i > answer)
                answer = i;
        }
        System.out.println(answer);
    }

    private static void solve() {
        for (int i = 1; i < n; i++) {
            //dp[i]를 바꾸려고 함
            int max = Integer.MIN_VALUE;
            for(int j = 0 ; j < i ; j++){
                if (arr[i] < arr[j]){
                    if (dp[j] > max)
                    {
                        max = dp[j];
                        dp[i] = max + 1;
                    }
                }else
                {
                    if (dp[i] <= 1)
                        dp[i] = 1;
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];
        dp[0] = 1;
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    }

}
