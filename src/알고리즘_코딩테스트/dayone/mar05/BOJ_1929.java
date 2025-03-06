package 알고리즘_코딩테스트.dayone.mar05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
    static int m, n;
    static int[] arr;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();


    }
    static void input() throws  IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for (int i = 2 ; i < n+1 ; i++){
            arr[i] = i;
        }

        //에라토스테네스의 체
        for (int i = 2 ; i<= Math.sqrt(n); i++){
            if (arr[i] == 0){
                continue;
            }
            for (int j= i+i; j <= n ; j+=i){
                arr[j] = 0;
            }
        }

        for (int i = m;  i < n+1 ;i++){
            if (arr[i] != 0)
                System.out.println(arr[i]);
        }


    }
}
