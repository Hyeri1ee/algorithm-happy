
import java.io.*;
import java.util.*;

class pack{
    int t;
    int p;

    pack(int t, int p){
        this.t = t;
        this.p = p;
    }
}
public class Main {
    static int n; //남은 n일
    static pack[] arr; //주어지는 t, p 정보를 담은 배열
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        input();
        solve();
        /*
        조건1: arr[i]의 t값 동안은 다른 상담 못함
        조건2: 1일에 일한 돈은 2일차에 누적됨
         */
    }
    private static void solve(){
        int[] dp = new int[n+1];
        //dp[i+arr[i].t] = 현재 i날에 잡힌 상담의 보수를 계산했을 때 얻는 금액 비교
        for(int i = 0; i < n; i++){
            if ( i + arr[i].t <= n){
                    dp[i + arr[i].t] = Math.max(dp[i + arr[i].t], dp[i] + arr[i].p );
            }//end of if

            if (i+1 <= n)
                dp[i+1] = Math.max(dp[i+1], dp[i]);
        }//end of for

        System.out.println(dp[n]);
        
    }
    private static void input() throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr= new pack[n+1];

        int t = n;
        StringTokenizer st;
        int i = 0;
        while(t-- > 0){
            st = new StringTokenizer(bf.readLine());
            int pack_t = Integer.parseInt(st.nextToken());
            int pack_p = Integer.parseInt(st.nextToken());

            arr[i] = new pack(pack_t, pack_p);
            i++;
        }
    }
}
