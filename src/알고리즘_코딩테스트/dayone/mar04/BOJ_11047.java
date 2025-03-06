package 알고리즘_코딩테스트.dayone.mar04;

import java.io.*;
import java.util.*;

public class BOJ_11047 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;

    public static void main(String[] args) throws IOException {
        int[] coins;
        //n , k (만들고자 하는 돈의 개수) 값 입력 받기
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        //n개의 동전 종류 입력받기
        coins = new int[n];
        for (int i = 0 ; i  < n ; i ++){
            coins[i] = Integer.parseInt(bf.readLine());
        }
        /*List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++){
            list.add(coins[i] );
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        //그리디로 최소 동전 개수 출력
        int count = 0;
        for (int coin : list){
            if (k / coin >= 1){
                int adding = k/coin;
                k -= (k / coin) * coin;
                count += adding;
            }
        }*/
        int count = 0;
        for (int i =n-1 ; i >= 0; i--){
            if (coins[i] < k){
                count += k / coins[i];
                k  = k % coins[i];
            }
        }
        System.out.println(count);
    }

}
