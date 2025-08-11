
import java.util.*;

public class Main {
    static int n;
    static long[] arr;
    static long[] dp;

    public static void main(String[] args){
        input();

        solve(n);//n까지 가는 가장 최대 점수 -> top down

        System.out.println(dp[n]);
    }

    private static long solve(int target){
        if (target <= 0) return 0;
        if (target == 1) return dp[1];
        if (target == 2) return dp[2];
        if (target == 3) return dp[3];

        if (dp[target] == 0){
            dp[target] = Math.max(solve(target-2), solve(target-3) + arr[target-1]) + arr[target];
            ///비교 : target 기준으로 2칸 vs 1칸 떨어진 경우
        }

        return dp[target];
    }

    private static void input(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new long[n+1];
        for(int i = 1 ; i <= n ;i++){
            arr[i] = sc.nextInt();
        }
        dp = new long[n+1];

        if(n == 1){
            dp[1] = arr[1];
        }else if (n == 2){
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
        }else{
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
        }

    }
}
