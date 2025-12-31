
import java.io.*;

public class Main {
    static long[][] dp;
//dp[len : 2][끝 : 1] = 0,2 => dp[len : 1][끝 : 1] x 2
//dp[len : 2][끝 : 2] = 1,3 => dp[len : 1][끝 : 1] x 2
//dp[len : 3][끝 : 4] = 1,3 => dp[len : 1][끝 : 1] x 2
    static int n;

    public static void main(String[]a ) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        dp = new long[n+1][10];
        for(int len = 1; len < n+1; len++){
            if (len == 1){
                for(int last = 1; last < 10; last++){
                    dp[len][last] = 1;
                }
            }else{
                for(int last = 0 ; last < 10; last++){
                    if (last == 0)
                        dp[len][last] =  dp[len-1][last+1]  %  1_000_000_000;
                    else if (last == 9)
                        dp[len][last] = dp[len-1][last-1] %  1_000_000_000;
                    else
                        dp[len][last] =  (dp[len-1][last+1] %  1_000_000_000) +  (dp[len-1][last-1] %  1_000_000_000);
                }
            }
        }

        //정답
        long answer = 0;
        for(int sum = 0 ; sum < 10 ; sum++){
            answer = (answer + dp[n][sum]) % 1_000_000_000;
        }

        System.out.println(answer);
    }
}
