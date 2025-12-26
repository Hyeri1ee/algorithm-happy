import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> p = new HashMap<>();
        HashMap<Integer, String> num = new HashMap<>();
        int i =1;
        for(String s : players){
            p.put(s, i);
            num.put(i, s);
            i++;
        }
        //디버깅
        
        for(String name : callings){
            int rank = p.get(name);
            int changedRank = rank -1; 
            String opponent = num.get(changedRank);
            
            //p에서의 자기 rank 바꾸기
            p.put(name, changedRank);
            //p에서의 상대 rank 바꾸기
            p.put(opponent, rank);
            //num에서의 자기 rank 바꾸기
            num.put(changedRank,name );
            //num에서의 상대 rank 바꾸기
            num.put(rank, opponent);
                  
        }
        
        String[] answer = new String[players.length];
        for(i = 0 ; i < players.length; i++){
            answer[i] = num.get(i+1);
        }
        return answer;
    }
}