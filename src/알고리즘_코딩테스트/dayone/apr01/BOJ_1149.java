package 알고리즘_코딩테스트.dayone.apr01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static int n;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int[][] arr;
        n = Integer.parseInt(bf.readLine());
        arr = new int[n+1][3];
        for(int i = 1 ; i <= n; i++){
            int num = 3;
            st = new StringTokenizer(bf.readLine());

            while(num > 0){
                arr[i][3-num--] = Integer.parseInt(st.nextToken());
            }
        }

        //input

        int[][] ch = new int[n+1][3];
        for(int i = 1; i <= n; i++){//down to top
            if (i == 1){//base
                ch[1][0] = arr[1][0];//빨강
                ch[1][1] = arr[1][1];//초록
                ch[1][2] = arr[1][2];//파랑
                continue;
            }


            ch[i][0] = Math.min(ch[i-1][1], ch[i-1][2]) + arr[i][0];
            ch[i][1] = Math.min(ch[i-1][0], ch[i-1][2]) + arr[i][1];
            ch[i][2] = Math.min(ch[i-1][0], ch[i-1][1]) + arr[i][2];

        }

        System.out.println(Math.min( Math.min(ch[n][0] , ch[n][1]), ch[n][2]));
/*
ch[i][j] = i까지의 집, 마지막 색깔은 j
ch[i][j] = min(ch[i-1][2-j], ch[i-1][1-j])
 */



    }
}
/*
3
26 40 83
49 60 57
13 89 99

96
 */
