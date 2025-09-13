
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    static int[] dp;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        input();
        dp[0] = 1;
        max = Math.max(max, dp[0]);
        for(int i = 1; i < n; i++){
            solve(i);
        }
        System.out.println(max);
    }
    private static void solve(int i){
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        max = Math.max(max, dp[i]);
    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ;i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }
    }
}
