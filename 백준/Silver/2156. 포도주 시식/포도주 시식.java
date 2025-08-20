

import java.util.*;


public class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        n = sc.nextInt();
        arr  =new int[n+1];
        dp = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = arr[1];
        if (n > 1)
            dp[2] = arr[1] + arr[2];

        System.out.println(deep(n));
    }

    private static int deep(int c){

        if(dp[c] == -1) {
            dp[c] = Math.max(Math.max(deep(c - 2), deep(c - 3) + arr[c - 1]) + arr[c], deep(c - 1));
            /*
            d
            */
        }

        return dp[c];

    }
}
