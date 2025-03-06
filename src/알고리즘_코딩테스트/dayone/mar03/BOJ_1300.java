package 알고리즘_코딩테스트.dayone.mar03;

import java.util.*;
import java.io.*;

public class BOJ_1300 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] oneline;

    public static void main(String[] args) throws IOException{
        //n, k 입력 받기
        n = Integer.parseInt(bf.readLine());
        k = Integer.parseInt(bf.readLine());
        long low = 1;
        long high = (long) n*n;


        //B[k] = x 이면, x보다 작은 수가 최소 k개  1 2 2 3 4 4 5 6
        //이분탐색
        while(low <= high){
            long x = (low + high) / 2; //임의의 long x
            long count = 0;
            for (int i = 1 ; i <= n; i++){
                count += Math.min(x / i , n);
            }
            if (count < k){
                low = x + 1;
            }else{
                high = x - 1;
            }
        }

        System.out.println(low);



    }
}
