package week3.day3;

import java.lang.reflect.Array;
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

    for(int i = 0 ; i < 4 ; i++){
      //'승','패'만 따로 저장
      int[] win = new int[MAX_TEAM_COUNT];
      int[] loose = new int[MAX_TEAM_COUNT];
      for (int j = 0 ; j < MAX_TEAM_COUNT; j++){
        //win[j] = matches[]
      }
    }



  }//end of main


}
