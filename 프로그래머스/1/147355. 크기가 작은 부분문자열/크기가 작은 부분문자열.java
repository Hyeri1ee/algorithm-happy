import java.io.*;
import java.util.*;

class Solution {
    static int answer = 0;
    static long num;
    
    public int solution(String t, String p) {
        num = Long.parseLong(p);
        for(int i = 0 ; i <= t.length() - p.length(); i++){

            
        
            long target = Long.parseLong(t.substring(i, i + p.length()) );
           
                        
           // System.out.println("[target ] : " + target);
            if (target <= num) answer ++; 
            
        }
        
        return answer;
    }
}