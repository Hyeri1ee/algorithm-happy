
import java.io.*;
import java.util.*;

/*
dp[초][s크기] = 얻은 당근 개수

최종적으로 dp[k]일때 가장 큰 것으로 출력
 */
public class Main {
    static int n, k;
    static int[] a;
    static int[] b;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        input();
        solve();


    }
    private static void solve(){
        for(int t = 0; t < k; t++){
            for(int s = 1; s<= 5000; s++){
                //현재당근 개수
                int carrot= dp[t][s];
                if(carrot < 0) continue;

                //그냥 뽑는 경우
                dp[t+1][s] = Math.max(dp[t+1][s], carrot+s);//뽑지 않는거 vs 뽑는거

                //투자하는 경우
                //n개 경우 중
                for(int i = 0 ; i < n ; i++){
                    if (carrot >= a[i] && s + b[i] <= 5000){
                        dp[t+1][s+b[i]] = Math.max(dp[t+1][s+b[i]], carrot-a[i]);//투자 안 하는거 vs 투자하는거
                    }
                }

            }
        }

        int ans= 0;
        for(int s = 1; s <= 5000; s++ ){
            ans = Math.max(ans, dp[k][s]);
        }
        System.out.println(ans);
    }



    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = stoi(st.nextToken());
        k = stoi(st.nextToken());
        a = new int[n];
        b = new int[n];
        //ai, bi를 입력받기
        for(int i = 0 ; i < n ; i++){
            st =  new StringTokenizer(br.readLine(), " ");
            int aa = stoi(st.nextToken());
            int bb = stoi(st.nextToken());
            a[i] = aa;
            b[i]   = bb;
        }
        dp = new int[k+2][];
        for(int i = 0; i <= k+1; i++){
            dp[i] = new int[5001];
            Arrays.fill(dp[i], -1);
        }
        dp[0][1] = 0;
        //dp[1][1] = 1;

    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
