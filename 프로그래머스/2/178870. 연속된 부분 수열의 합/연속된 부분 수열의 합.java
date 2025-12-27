import java.io.*;
import java.util.*;
//투포인터
class Solution {
    static int n;
    static long[] sum;
    //static int[] answer = null;
    
    public int[] solution(int[] sequence, int k) {
        n = sequence.length;
        sum = new long[n+1];
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans += sequence[i];
            sum[i+1] = ans;
        }
        
        int left = 0;
        int right = 1;

        int bestLen = Integer.MAX_VALUE;
        int bestL = 0, bestR = 0;
        
        while(left < n&& right <= n){
        
            long curr = sum[right] - sum[left]; //sequence에서는 인덱스 [left, right-1]
            if (curr < k){
                right++;
                
            }else if (curr > k){
                left++;
                if (left >= right) right = left + 1;
            }else{//curr == k
                int len = right - left;

                if (len < bestLen) {
                    bestLen = len;
                    bestL = left;
                    bestR = right - 1;
                }

                left++;
                
            }
            
            
        }
        
        
        
      
        
        return new int[] {bestL, bestR};
    }
    /*
    public static int init(int start, int end, int node) {
		if(start == end)
			return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}
    
    
    public static int sum(int start, int end, int node, int left, int right) {

		if(left > end || right < start)
			return 0;
		

		if(left <= start && end <= right)
			return tree[node];
		

		int mid = (start + end) / 2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node * 2 + 1, left, right);
	}
    
   */ 
    
    
    
}