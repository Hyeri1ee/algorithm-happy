
import java.util.*;

public class Main {
    static int n;
    static int answer = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 0; 

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1]+1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i]=Math.min(dp[i], dp[i / 3] + 1);
            }
        }//최소 값을 고려 min함수로

        System.out.println(dp[n]);
    }

    private static void check(){
        if (n % 3 == 0){
            answer++;
            n /= 3;
        }else if (n % 2 == 0){
            answer++;
            n /= 2;
        }else {
            answer++;
            n -= 1;
        }
        return;
    }
}
