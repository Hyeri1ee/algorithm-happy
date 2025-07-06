package 알고리즘_코딩테스트.dayone.apr06;

import java.io.*;
import java.util.*;

public class boj_14889 {
    static int n;
    static int[][] cost;
    static boolean[] visit;
    static long min;

    public static void main(String[] args) throws  IOException{
        input();
        Arrays.fill(visit,false);

        visit[1] = true;
        solve(1, 1);

    }

    private static void solve(int dot, int cur){
        if (cur == n)
            return;

        for(int next = 1; next <= n; next++){
            if (cost[dot][next] > 0 && !visit[next] && next != dot){
                visit[next] = true;

                solve(next, cur++);

                visit[next] = false;
            }
        }

    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        cost = new int[n+1][n+1];
        visit = new boolean[n+1];

        StringTokenizer st;
        for(int i = 1; i <= n ; i++){
            st = new StringTokenizer(bf.readLine());
            cost[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
