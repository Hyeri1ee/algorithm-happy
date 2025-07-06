package 알고리즘_코딩테스트.dayone.mar31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2
2 0
3 1

1
 */
public class BOJ_24460 {
    static int n;
    static int[][] arr;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        input();

        //solve();
    }
    private static void input()throws IOException{
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];

        for(int i = 0 ; i < n ; i ++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j =0; j <n;j++){

            }
        }

    }
}
/*
n

n % 3

외판원 순회

경로가 없는 경우 가장 높은 값을 주면 됨

p.78 29



 */