package 알고리즘_코딩테스트.dayone.apr04;

import java.io.*;
import java.util.*;

class answer{
    int x; int y;

    public answer(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class BOJ_11659 {
    /*
5 3
5 4 3 2 1
1 3
2 4
5 5

12
9
1
     */


    static int n,m;
    static int[] arr; //합
    static answer[] answers;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        inpur();
        solve();
    }

    private static void solve(){

        for(int i = 1; i < m+1; i++){
            System.out.println(arr[answers[i].y] - arr[answers[i].x-1]);
        }

    }
    private static void inpur()throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        answers = new answer[n+1];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i+1] = Integer.parseInt(st.nextToken()) + arr[i];
        }

        int x;
        int y;
        for(int i = 1; i <= m ; i++){
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            answers[i] = new answer(x,y);
        }



    }
}
