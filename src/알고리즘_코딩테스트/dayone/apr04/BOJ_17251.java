package 알고리즘_코딩테스트.dayone.apr04;

import java.io.*;
import java.util.*;

public class BOJ_17251 {

    /*
6
9 15 18 7 13 11

R
     */

    static int n;
    static int[] arr;

    public static void main(String[] args)throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int left = 0;
        int right = 0;
        for(int i =1 ; i <=  n-1; i++){
            if (arr[i] < arr[n]-arr[i])
                right++;
            else if (arr[i] > arr[n]-arr[i])
                left++;

        }

        if (left> right)
            System.out.println("R");
        else if (left<right)
            System.out.println("B");
        else
            System.out.println("X");
    }

    private static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 1;  i <= n ; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];

        }
    }

}
