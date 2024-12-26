package old.week3.day3;

import java.util.*;
import java.io.*;

public class P6987{
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int [][] result = new int[4][18];
  static int T = 4;
  public static void main(String [] args)throws Exception{
    for (int i = 0 ; i <  4 ; i++){
      StringTokenizer st = new StringTokenizer(bf.readLine());
      int j = 0;
      while(st.hasMoreTokens()){
        if (result[i][j] > 5)
        result[i][j] = Integer.parseInt(st.nextToken() );
        j++;
      }//end of while
    }//end of for
    int testCaseNum = 0;
    while(T-- > 0){//4 가지 테스트 케이스에 대해서
      //승 = 패 - 개수

      //무승부 - 짝 개수

      if (checkWin(testCaseNum) && checkSame(testCaseNum)){
        sb.append("1 ");
      }else{
        sb.append("0 ");
      }
      testCaseNum++;


    }//end of while T--
    System.out.println(sb);
  }

  public static boolean checkWin(int n){
    int winCount =0;
    int looseCount = 0;

    for (int i =  0 ; i < 18 ; i += 3){
      if (result[n][i] > 5 || result[n][i+1] > 5)//5이하인지 검사
        return false;
      winCount += result[n][i];
      looseCount += result[n][i+2];

    }
    if (winCount == looseCount)
      return true;
    else return false;
  }

  public static boolean checkSame(int n){
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 15; i += 3){
      int adding = result[n][i+1];
      if (adding > 0)
        list.add(adding);
    }//end of for
    boolean answer = false;
    int startSize = list.size();
    while(!list.isEmpty()){
      int k = list.get(0);
      list.remove(0);
      if (list.size() == 0)//무승부가 한개만 있는 경우
        return answer;
      for (int i =  0; i < list.size(); i++){
        if (list.get(i) == k){
          list.remove(i);
          break;
        }
      }
      if (startSize -2 == list.size())
        answer = true;
      else
      {
        answer = false;
        break;
      }
    }//end of while
    if (list.isEmpty())
      answer = true;
    return answer;

  }



}