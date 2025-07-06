package 알고리즘_코딩테스트.dayone.apr03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_12865 {

    /*
4 7
6 13
4 8
3 6
5 12

14
     */
    static class item{
        int weight, value;

        public item (int w, int v){
            this.weight = w;
            this.value = v;
        }

    }
    static int n, k;
    static item[] items;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        input();
        solve();

    }
    private static void solve(){
        int[][] dp = new int[n+1][]; //dp[i][j] = i번째까지의 물건을 고려했을 때, j무게 이하의 물건의 무게 합
        for(int i =0 ; i <= n; i++){
            dp[i] = new int[k+1];
        }


        for(int i =1 ; i <= n ;i++){
            for(int j = 1; j < k+1 ; j++){
               dp[i][j] = dp[i - 1][j];
               if (items[i].weight <= j){
                   dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i].weight] + items[i].value);
               }
           }
       }

        System.out.println(dp[n][k]);



    }
    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        items = new item[n+1];

        for(int i = 1 ; i <= n; i++){
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i] = new item(w,v);
        }

        //end input
    }
}
