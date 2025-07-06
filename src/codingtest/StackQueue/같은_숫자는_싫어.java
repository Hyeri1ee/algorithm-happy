package codingtest.StackQueue;

import java.io.*;
import java.util.*;


//Solution 클래스
class Solution {
    static public int[] solution(int []arr) {

        Stack<Integer> stacks = new Stack<>();
        for(int i = 0 ; i < arr.length; i++){
            int now = arr[i];
            great(now,stacks);
        }

        // Stack -> int[] 변환
        int[] answer = new int[stacks.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stacks.pop();
        }


        return answer;
    }

    static void great(int now, Stack<Integer> stacks){
        if (!stacks.isEmpty()){
            int top = stacks.peek();
            if (top == now)
                return;
        }
        stacks.push(now);
    }
}

//메인 클래스
public class 같은_숫자는_싫어 {
    static int[] arr;
    static int[] answer;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        input();
        solve();

    }

    static void solve(){
        answer = Solution.solution(arr);
        for(int i = 0 ; i < answer.length; i++)
            System.out.print(answer[i] +" ");
    }



    static void input() throws IOException {
        String line = bf.readLine();
        String[] parts = line.split(" ");
        arr = new int[parts.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
    }
}

