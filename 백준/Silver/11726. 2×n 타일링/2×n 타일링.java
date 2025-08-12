
import java.util.*;

public class Main {
    static int n;
    static long[] dp;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        dp = new  long[n+1];
        if (n==1)
        {
            System.out.println(1);
            return;
        }
        if (n == 2)
        {
            System.out.println(2);
            return;
        }

        //초기화
        dp[1] = 1; dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] % 10_007) + (dp[i-2] % 10_007);
        }

        System.out.println(dp[n] % 10_007);

    }
}
