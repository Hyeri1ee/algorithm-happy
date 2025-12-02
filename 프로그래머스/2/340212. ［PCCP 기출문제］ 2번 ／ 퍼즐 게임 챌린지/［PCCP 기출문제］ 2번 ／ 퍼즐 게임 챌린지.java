
/*
숙련도의 최댓값의 최솟값은 diffs 배열의 max
숙련도의 최솟값은 1

이분탐색의 기준 limit
 */
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = maxof(diffs);
        int answer = right;

         while (left <= right) {
            int mid = (left + right) / 2;
            long time = puzzle(diffs, times, mid);

            if (time <= limit) {
              //mid 숙련도로 limit 안에 들어옴 → 더 낮은 숙련도로 도전
              answer = mid;
              right = mid - 1;
            } else {//time > limit
              //시간 초과 → 더 높은 숙련도 필요
              left = mid + 1;
            }
          }

        return answer;
   }

    private static long puzzle(int[] diffs, int[] times, int level){
      long result = 0;

        for(int i = 0 ; i < diffs.length; i++){
          int diff = diffs[i];
          int time = times[i];

          if (diff > level){
            int repeat = diff - level;
           
            result += (time + times[i-1]) * repeat; //i > 1
            
            
          }
          
          
          result += time;
          

        }


        return result;
    }

    private static int maxof(int[] diffs){
      int max = 0;
      for(int i = 0 ; i < diffs.length; i++){
        if (max < diffs[i]) max = diffs[i];
      }

      return max;
    }
}