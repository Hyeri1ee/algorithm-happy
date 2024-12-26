package old.week3.day3;

import java.util.*;
import java.io.*;

/**
 * 각 나라 당 승+무+패 = 5 &&
 * 총 경기 수  = 15  ---- 승 총합 = 패 총합 나머지는 무 에서
 */

public class P6987Other {

  static int [][] matches;
  static final int T = 4; //테스트 케이스 수
  static final int MAX_TEAM_COUNT = 6;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    matches = new int[T][MAX_TEAM_COUNT*3];
    for (int i = 0 ; i <  T ; i++){
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int j = 0;
      while(st.hasMoreTokens()){
          matches[i][j] = Integer.parseInt(st.nextToken());
        j++;
      }//end of while
    }//end of for

    for(int i = 0 ; i < 4 ; i++){//각 케이스(한 줄) 마다
      //'승','패'만 따로 저장
      int[] win = new int[MAX_TEAM_COUNT];
      int[] loose = new int[MAX_TEAM_COUNT];
      int winSecondIndex = 0; int looseSecondIndex = 2;
      for (int j = 0 ; j < MAX_TEAM_COUNT; j++){
        win[j] = matches[i][winSecondIndex];
        loose[j] = matches[i][looseSecondIndex];
        winSecondIndex += 3;
        looseSecondIndex += 3;

        int count = 0 ;
        //1. 승 패 매칭
        boolean[] visited = new boolean[MAX_TEAM_COUNT];
        for (int k = 0 ; k < MAX_TEAM_COUNT;k++){
          for (int l = 0 ;l < MAX_TEAM_COUNT; l++ ){
            if (win[k] == loose[l] && !visited[l]){
              visited[l] = true; //loose 배열을 기준으로 true 값으로 변경
              count ++;
            }

          }
        }//end of for

      }
    }



  }//end of main


}
