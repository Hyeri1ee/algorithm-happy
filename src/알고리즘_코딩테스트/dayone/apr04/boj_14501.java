package 알고리즘_코딩테스트.dayone.apr04;

import java.io.*;
import java.util.*;

/*
삼성sw역량테스트

주의

dp[i + arr[i].t] = Math.max(dp[i + arr[i].t], dp[i] + arr[i].p )
=> 현재날의 상담 기간을 계산했을 때 끝나는 날에 받을 보수

i일에 마무리한 일에 대한 보수는 i+1일에 누적됨
 */
class pack{
    int t;
    int p;

    pack(int t, int p){
        this.t = t;
        this.p = p;
    }
}
public class boj_14501 {
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
        //dp[i] : i일까지 벌 수 있는 최대 수익
        //dp[i+arr[i].t - 1] = 현재 i날에 잡힌 상담의 보수를 계산했을 때 끝난 날에 얻는 보수
        //보수를 얻은 것은 상담이 끝나는 날인 i+arr[i].t -1 일에 기록됨
        /*
        i = 1인 경우, => 1일차에 잡을 수 있는 상담을 잡은 경우
        arr[i].t = 3일이 걸리는 상담일때,
        i+arr[i].t-1 = 3 => 3일차에 dp[3]에 보수 받음

        dp [ i + arr[i].t - 1 ] 값은 보수를 안 받았을 때 보수 받을 예정인 날의 지금까지의 보수
        dp[i-1] + arr[i].p 값은
         : 현재 i일째의 잡을 수 있는 상담을 했을 때 받을 수 있는 보수 -> arr[i].p와
         : dp[i-1] 지난 i-1날까지의 최대 보수

         */
        for(int i =1 ; i<= n ;i++){
            if (i + arr[i].t - 1 <= n){//보수는 최대 n일차까지 받을 수 있음
                dp[i+arr[i].t -1] = Math.max(dp[i + arr[i].t - 1], dp[i-1] + arr[i].p);
            }

            if (i+1 <= n){
                dp[i+1] = Math.max(dp[i], dp[i+1]);
            }
        }

        System.out.println(dp[n]);
        
    }
    private static void input() throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr= new pack[n+1];

        int t = n;
        StringTokenizer st;
        int i = 1;
        while(t-- > 0){
            st = new StringTokenizer(bf.readLine());
            int pack_t = Integer.parseInt(st.nextToken());
            int pack_p = Integer.parseInt(st.nextToken());

            arr[i] = new pack(pack_t, pack_p);//i일차에 잡을 수 있는 상담 정보
            i++;
        }
    }
}
