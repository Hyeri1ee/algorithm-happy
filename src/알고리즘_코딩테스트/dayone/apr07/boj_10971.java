package 알고리즘_코딩테스트.dayone.apr07;

import java.io.*;
import java.util.*;

public class boj_10971 {

/*
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0


35
 */

    static int n;
    static int[][] arr;
    static boolean[] visited;
    static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }

    /**
     * start : 메서드 실행 전 위치
     * now : 현재 내가 위치한 도시
     * sum : 현재위치한 도시까지 사용한 비용
     * depth : 1부터 n이 될때까지만 -> dfs 종료조건 변수
     */
    private static void solve(){

        for (int i = 1; i < n+1; i++) {
            visited[i] = true;
            dfs(i, i, 0, 1);
        }

        System.out.println(answer);
    }

    private static void dfs(int start, int now, long sum, int depth){
        if (depth == n){
            if (arr[now][start] != 0){
                sum += arr[now][start];
                answer = Math.min(answer, sum);
            }
            return;
        }

        for(int i = 1 ; i <= n ; i++){
            if (!visited[i]){//방문안한 점이면
                if (arr[now][i] != 0){
                    visited[i] = true; // 방문 함
                    dfs(start, i, sum + arr[now][i] , depth + 1);
                    visited[i] = false; // 방문 끝
                }
            }
        }


    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=1 ; i <= n ;i++){
            st = new StringTokenizer(bf.readLine());
            int j = n;
            while(j >0){
                arr[i][n+1 - j] = Integer.parseInt(st.nextToken());
                j--;
            }

            //System.out.println(arr[i][n]);
        }

    }
}
