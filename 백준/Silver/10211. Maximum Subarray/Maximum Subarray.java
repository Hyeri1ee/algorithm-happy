
import java.io.*;
import java.util.*;

/*
각 테스트 케이스마다
n
arr = 1 2 3 4 5
dp[arr에서 시작 인덱스(0,n-1)][부분수열 길이(1~n)] = arr의 시작 인덱스부터 부분 수열 길이 만큼 획득한 합
dp[a][i] = max(dp[a][i-1], dp[a][i-1] + arr[a+i]) //끝내든지 vs 계속 가든지
 */
public class Main {
    static int t;
    static int n;
    static long[] arr;
    static long[][] dp;

    static BufferedReader   bf = new BufferedReader(new InputStreamReader(System.in));

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        t = stoi(bf.readLine());
        for(int i = 0 ; i < t; i++){
            input();
            solve();
        }
        System.out.println(sb);
    }
    private static void solve(){
/*
dp[arr에서 시작 인덱스(0,n-1)][부분수열 길이(1~n)] = arr의 시작 인덱스부터 부분 수열 길이 만큼 획득한 합
dp[a][i] = max(dp[a][i-1], dp[a][i-1] + arr[a+i]) //끝내든지 vs 계속 가든지
*/
        /*
        for (int s = 0; s < n; s++) {
            dp[s][1] = arr[s]; //길이 1 부분배열
            for (int j = 2; j <= n - s; j++) {
                dp[s][j] = Math.max(dp[s][j-1] + arr[s + j - 1], arr[s + j - 1]);//계속 갈지 vs 끊을지
            }
        }

        long max = Long.MIN_VALUE;
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j <= n; j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }


        sb.append(max).append("\n");*/

        long max = arr[0];
        long sum = arr[0];

        for (int i = 1; i < n; i++) {
            sum = Math.max(arr[i], sum + arr[i]); // 이어가기 vs 새로 시작
            max = Math.max(max, sum);             // 최댓값 갱신
        }

        sb.append(max).append("\n");
    }
    private static void input() throws IOException{
        n = stoi(bf.readLine());
        arr = Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        dp = new long[n][];
        for(int i = 0 ; i < n; i++){
            dp[i] = new long[n+1];
        }
    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
