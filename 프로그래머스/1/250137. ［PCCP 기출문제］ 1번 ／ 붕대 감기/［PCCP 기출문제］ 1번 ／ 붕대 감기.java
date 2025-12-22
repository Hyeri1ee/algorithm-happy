import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int savehealth = health;
        int inrow = 0; //연속 성공 수
        int time= 0;//현재 시각
        
        
        HashMap<Integer, Integer> map= new HashMap<>();
        for (int i =0; i < attacks.length; i++){
            map.put(attacks[i][0], attacks[i][1]);
        }
        
        int lastTime = attacks[attacks.length - 1][0];  
        for (int i = 0; i <= lastTime; i++){
            if (health == 0) break;
            boolean attacked = false;
            
            
            if (map.containsKey(time)){
                attacked = true;
                inrow = 0;
                
                if(health - map.get(time) <= 0)
                    health = 0;
                else
                    health -= map.get(time);
                
                System.out.println("[감소된 health] : " + health);
                
                
            }else{
                health = (health + bandage[1] >= savehealth) ? savehealth : health + bandage[1];
                inrow ++; //초당 회복량 추가
                if (inrow == bandage[0]) {//시전 시간
                    health = (health + bandage[2] >= savehealth) ? savehealth : health + bandage[2]; //추가회복량 추가
                    inrow = 0;
                }
            }
            
            
            //디버깅용
            System.out.println("[현재 시각] : " + time );
            System.out.println("[현재 체력] : " + health);
            System.out.println("[연속 성공] : " + inrow);
            System.out.println("[공격함] : " + attacked);
            time++;
        }
        
        return (health == 0) ? -1 : health;
    }
}