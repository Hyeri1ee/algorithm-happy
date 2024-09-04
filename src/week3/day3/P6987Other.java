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
    for (int i =  0 ; i < T; i++){
      int[] matchCase = matches[i];
      boolean eachCountrySum5 = eachCountrySum5(matchCase);
      boolean totalMatch15;
      if (eachCountrySum5){
        totalMatch15 = totalMatch15(matchCase);
        if (totalMatch15)
          sb.append(1 +" ");
        else
          sb.append(0 + " ");
      }
      else
        sb.append(0 + " ");

    }
    System.out.println(sb);

  }

  private static boolean eachCountrySum5(int[] a){
    boolean result =  true;
    for (int i =0;i < MAX_TEAM_COUNT * 3; i += 3){
      if (a[i] + a[i+1] + a[i+2] != 5) {
        result = false;
        break;
      }
    }
    return result;
  }

  private static boolean totalMatch15(int[] a){
    boolean result =  false;
    //승 총합
    int winSum = 0;
    for (int i =0;i < MAX_TEAM_COUNT * 3; i += 3){
      winSum += a[i];
    }
    //패 총합
    int looseSum = 0;
    for (int i =2;i < MAX_TEAM_COUNT * 3; i += 3){
      looseSum += a[i];
    }
    //무 총합
    int evenSum = 0;
    ArrayList<Integer> even = new ArrayList<>();
    for (int i =1;i < MAX_TEAM_COUNT * 3; i += 3){
      evenSum += a[i];
      if (a[i] > 0)
        even.add(a[i]);
    }

    //비교
    if ( (winSum == looseSum) && (winSum + (evenSum / 2) == 15))
    {
      if (checkSame(even))
        result = true;
    }

    return result;
  }

  private static boolean checkSame(ArrayList<Integer> even){

    // 무승부 횟수의 총합이 짝수인지 확인
    int sum = even.stream().mapToInt(Integer::intValue).sum();
    if (sum % 2 != 0) {
      return false; // 총합이 홀수이면 짝이 맞을 수 없으므로 false 반환
    }

    return canPair(even, 0);
  }

  // 재귀적으로 짝지을 수 있는지 확인하는 함수
  private static boolean canPair(ArrayList<Integer> even, int start) {
    // 모든 팀이 짝지어졌다면 true 반환
    if (start >= even.size()) {
      return true;
    }

    // 현재 팀의 무승부 횟수
    int current = even.get(start);

    // 현재 무승부 횟수가 0인 경우는 넘어감
    if (current == 0) {
      return canPair(even, start + 1);
    }

    // 다음 팀과 짝지을 수 있는지 확인
    for (int i = start + 1; i < even.size(); i++) {
      if (even.get(i) > 0) {
        // 현재 팀과 짝지을 수 있는 경우 시도
        even.set(i, even.get(i) - current);

        // 현재 짝지은 팀들을 제외하고 나머지 팀들로 재귀 호출
        if (canPair(even, start + 1)) {
          return true;
        }

        // 실패한 경우 원래 상태로 복구
        even.set(i, even.get(i) + current);
      }
    }

    // 어떤 팀과도 짝지을 수 없다면 false 반환
    return false;
  }



}
