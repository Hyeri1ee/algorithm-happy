
import java.io.*;
import java.util.*;

public class Main {
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
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < n; i++){
            list.add(coins[i] );
        }

        Collections.sort(list, Collections.reverseOrder());
        //그리디로 최소 동전 개수 출력
        int count = 0;
        for (int coin : list){
            if (k / coin >= 1){
                int adding = k/coin;
                k -= (k / coin) * coin;
                count += adding;
            }
        }
        System.out.println(count);
    }

}
