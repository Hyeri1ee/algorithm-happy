package 알고리즘_코딩테스트.dayone.feb15;

import java.io.*;
import java.util.*;

public class BOJ_10989 {
    static int n;
    static int[] arr;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        int max = 0;
        arr = new int[10001];
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(bf.readLine())]++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1 ; i< 10001; i++){
            while(arr[i] > 0){
                sb.append(i).append("\n");
                arr[i]--;
            }
        }
        System.out.println(sb);





    }
}
