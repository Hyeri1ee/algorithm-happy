
import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int k;
    static int[] arr;

    static int[][] dp;
    static int[] sum;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(bf.readLine());
        while(t-- > 0){
            k = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine()," ");
            arr = new int[k+1];
            sum = new int[k+1];
            for(int i = 1; i <= k; i++){
                arr[i] = Integer.parseInt(st.nextToken()   );
                sum[i] = sum[i-1] + arr[i];
            }

            dp = new int[k+1][k+1];

            for(int i = 1; i <= k; i++){
                dp[i] = new int[k+1];
            }

            //solve
            for(int n = 1; n <= k ; n++){//몇 장
                for(int start = 1; start + n <= k; start++){
                    int end = start+ n;

                    dp[start][end] = Integer.MAX_VALUE;
                    for(int d = start; d < end ;d++){
                        dp[start][end] = Math.min(dp[start][end],
                                dp[start][d] + dp[d+1][end] + sum[end] - sum[start-1]);
                        //start, end까지의 최소 비용 = maxvalue <vs> start d까지 비용 + d+1 end까지 비용 + 최종 마지막 전체 비용
                    }
                }
            }

            sb.append(dp[1][k]+"\n");
        }//end of while


        System.out.println(sb);

    }

}
