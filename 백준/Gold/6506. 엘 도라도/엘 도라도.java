
import java.io.*;
import java.util.*;
/*
10 5
1 2 3 4 5 6 7 8 9 10
3 2
3 2 1
0 0

252
0

N까지 길이가 K인 수열의 개수 (즉 N번째 수를 반드시 포함)
DP[N][K] = DP[1][K-1] + DP[2][K-1] + DP[3][K-1] .... + DP[N-1][K-1]
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] arr;
    static long[][] dp;
    static StringBuilder sb = new StringBuilder();

    static int flag = 0;

    public static void main(String[] args) throws IOException {
        while(true){
            input();
            if (flag == 0)
            {
                solve();
                //sb에 dp[~][k]만 다 합해서 추가
                addsb();
            }else{
                break;
            }
        }

        System.out.println(sb);
    }

    private static void addsb(){
        long answer = 0 ;
        for(int i = 1 ; i <= n ; i++){
            answer += dp[i][k];
        }

        sb.append(answer + "\n");
    }
    private static void solve(){
       for(int i = 2; i <= n; i++){
           for(int j = i-1; j >= 1; j--){
               if (arr[j] > arr[i])
                   continue;
               
               //k 이하의 수열의 개수 저장
               for(int a = 2; a <= k; a++){
                   dp[i][a] += dp[j][a-1];//현재 arr[j] < arr[i] 이므로, arr[i]를 포함할때, 가능한 수열 개수
               }
           }
       }
    }
    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        k = stoi(st.nextToken());
        if (n ==  0 && k == 0) {
            flag = 1;
            return;
        }
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = stoi(st.nextToken());
        }

        dp = new long[n+1][];
        for(int i = 1; i <= n; i++){
            dp[i] = new long[k+1];
        }

        init();

    }
    
    private static void init(){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= k; j++){
                dp[i][j] = 0;
            }
            dp[i][1] = 1; //초기화
        }
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
