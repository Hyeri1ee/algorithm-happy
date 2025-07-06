package 알고리즘_코딩테스트.dayone.mar28;

import java.io.*;
import java.util.*;

public class BOJ_30459 {
    /*
3 5 23
-5 0 5
1 6 2 8 10
     */
    static int n,m,r;
    static int[] base;
    static int[] flag;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{

        input();

        solve();
    }
    private static void solve() {
        Arrays.sort(base);
        Arrays.sort(flag);

        double maxArea = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int baseLen = Math.abs(base[j] - base[i]);

                //높이 고려
                int left = -1, right = m;
                while (left+1 < right) {
                    int mid = (left + right) / 2;
                    double area = baseLen * flag[mid] / 2.0;

                    if (area <= r) {
                        maxArea = Math.max(maxArea, area);
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
            }
        }

        System.out.print(maxArea == -1 ? "-1" : String.format("%.1f", maxArea));
    }
    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m =  Integer.parseInt(st.nextToken());
        r =  Integer.parseInt(st.nextToken());
        base = new int[n];
        flag = new int[m];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i  < n ; i ++){
            base[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i  < m ; i ++){
            flag[i] = Integer.parseInt(st.nextToken());
        }




    }
}
