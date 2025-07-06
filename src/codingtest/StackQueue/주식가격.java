package codingtest.StackQueue;

import java.io.*;
import java.util.*;
/*
가격이 떨어지지 않은 기간 : 단순 배열 비교
 */
class Solution4{

    public int[] solution(int[] prices){
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length; i++){
            int count = 0;
            for(int j = i+1; j< prices.length; j++){
                count++;
                if (prices[i] > prices[j]) break;

            }
            answer[i] = count;
        }
        return answer;
    }
}
public class 주식가격 {
    static int[] prices;
    public static void main(String[] args) throws  IOException{
        input();
        solve();
    }

    static void input() throws IOException{
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        prices = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

    }

    static void solve(){
        int[] answer = new Solution4().solution(prices);
        for(int e : answer)
            System.out.print(e+" ");
    }
}
