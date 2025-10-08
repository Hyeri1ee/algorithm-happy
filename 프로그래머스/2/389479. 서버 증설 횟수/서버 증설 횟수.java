import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int ans = 0;
        
        int[] server = new int[24];//현재 서버 수
        //Arrays.fill(server, 1);
        int userperserver = m;
        boolean firstnotzero = false;
        int needServer = 0;
        
        for(int p = 0;p<24; p++){
            
            int curPlayer = players[p];
           
           
            needServer = curPlayer / userperserver;
            
            int realneedServer = needServer - server[p];//현재시점
            
            if (realneedServer > 0){
                ans += realneedServer;
                for(int t = p; t < Math.min(24, p+k) ; t++){
                    server[t] += realneedServer;
                }
            }
        }
        
        return ans;
    }
}