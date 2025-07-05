import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        

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

