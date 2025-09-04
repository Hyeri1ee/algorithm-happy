import java.io.*;
import java.util.*;

class Solution {
    /*
    schedules[i] : i+1번째 직원이 설정한 출근 희망 시각
    timelogs[i][j]는 i + 1번째 직원이 이벤트 j + 1일차에 출근한 시각을 의미
    startday로 토,일 판별해서 제외
    
    //구현
    //1.schedules를 '출근 인정 시각'으로 변환
    //2.for2중 if (check[i] ) timelogs -> schedules
    //3. boolean check true로 초기화후 -> 늦은 사람 그 즉시 false로 변환
    //4. check내 true개수 반환
    
    */
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        boolean[] check = new boolean[schedules.length];
        Arrays.fill(check, true);
        //1.
        for(int i = 0 ; i < schedules.length; i++){
            int newOrigin = schedules[i] + 10;
            if (newOrigin % 100 >= 60){
                //시분 조정 필요
                int h = newOrigin / 100;
                h += 1; //시 +1
                int m = newOrigin % 100;
                m %= 60; //분 - 60
                schedules[i] = h * 100 + m;
            }else{
                schedules[i] = newOrigin;
            }
        }
        //2.
        
        for(int j = 0 ; j < 7; j++){//j일차 = startday 요일
            if (startday == 6 || startday == 7) {
                startday = (startday % 7) + 1; // 요일 증가 (1~7 반복)
                continue;
            }
            for(int i = 0 ; i < timelogs.length; i++){//i+1번째 직원
                if (check[i]){
                    int realTime = timelogs[i][j];
                    if (realTime > schedules[i])//초과됨
                    {
                        check[i] = false;
                    }
                }//end of if
                
            }//end of i for
            startday++;
        }//end of j for
        
        
        //4.
        int ansewr = 0;
        for(int i = 0 ; i < check.length; i++)
        {
            if (check[i])
                ansewr++;
        }
        
        return ansewr;
    }
}