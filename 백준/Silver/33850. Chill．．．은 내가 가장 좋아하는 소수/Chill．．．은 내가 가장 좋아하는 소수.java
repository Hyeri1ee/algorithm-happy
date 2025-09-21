
import java.io.*;
import java.util.*;

public class Main {
    static int n, a, b;
    static int[] row1, row2;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        row1 = new int[n+1];
        row2 = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) row1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) row2[i] = Integer.parseInt(st.nextToken());

        //소수 판정 미리
        int maxVal = 200000;
        isPrime = new boolean[maxVal + 1];

        
        sieve(maxVal);

        long[] dp = new long[n+1];
        dp[0] = 0;
        if (n >= 1) {
            int sum = row1[1] + row2[1];
            dp[1] = (isPrime[sum] ? a : b);
        }

        for (int i = 2; i <= n; i++) {
            //세로 타일
            int vertical = row1[i] + row2[i];
            long scoreVertical = dp[i-1] + (isPrime[vertical] ? a : b);

            //가로 타일
            int sum1 = row1[i-1] + row1[i];
            
            int sum2 = row2[i-1] + row2[i];
            long scoreHorizontal = dp[i-2] +
                    (isPrime[sum1] ? a : b) + (isPrime[sum2] ? a : b);

            dp[i] = Math.max(scoreVertical, scoreHorizontal);
        }

        System.out.println(dp[n]);
    }

    static void sieve(int max) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i*i <= max; i++) {


            if (isPrime[i]) {
                for (int j = i*i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
