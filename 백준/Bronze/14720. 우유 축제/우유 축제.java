

import java.io.*;
import java.util.*;
/*
이전 상태, 현재 보는 값

dp[i] = want
 */
public class Main {
    static int n;
    static int[] arr;
    static int[] dp ;
    public static void main(String[] args) throws IOException{

        input();
        int want = 0;
        int count = 0;

        dp = new int[n];
        for(int i = 0 ; i < n ; i++){
            if (arr[i] == want)
            {
                want = (want+1) %3;//0 1 2 순환
                count++;
            }
        }

        System.out.println(count);

    }
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = stoi(bf.readLine());
        arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
