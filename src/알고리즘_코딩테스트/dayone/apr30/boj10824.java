package 알고리즘_코딩테스트.dayone.apr30;

import java.io.*;
import java.util.*;

public class boj10824 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long a1 = change(arr[0], arr[1]);
        long a2 = change(arr[2], arr[3]);
        System.out.println(a1 + a2);
    }

    private static long change(int a, int b){
        return Long.parseLong(String.valueOf(a) + String.valueOf(b));
    }
}
