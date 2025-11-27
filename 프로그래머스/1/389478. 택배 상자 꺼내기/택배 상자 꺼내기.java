/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;


/*

적어도 Num이 어느 층에 있는지는 알 수 있음 = i층

90도 오른쪽으로 회전시키기

int[]][]  arr
arr[j][i] 
=> i 가 짝수이면, j가 감소하는 방향으로 탐색
=> i 가 홀수이면, j가 증가하는 방향으로 탐색 (없는 경우도 존재 -> 처리하기 위해 int[][]바꾸기)

좋은 경우(w=1), i=n  
최악 경우(w=n), i=0 O(n)

 */

class Solution {
  static int[][] arr;
  //이 부분 삭제
  //static int n, w, num;

  static int x, y;
  
  //이 부분 삭제
  /* 
  public static void main(String[] args)throws Exception{
    input();
    init(n,w, num);
    solve();
  }
  */
  public int solution(int n, int w, int num) {

    
    //초기화
    init(n,w, num);
    //해결
    int answer = solve();
 

    return answer;
    
  }
  private static int solve(){
    int count = 0;
    //System.out.println("x,y : "+ x + ", " + y);
    //System.out.println("arr[0].length : " + arr[0].length);

      for(int i=y; i< arr[0].length; i++){
        //System.out.println("arr["+x+"]["+i+"] : " + arr[x][i] + "빼내짐");
        if(arr[x][i] != 0){
          count++;
        }
      }

    return count;
  }

  private static void input() throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    //n = Integer.parseInt(st.nextToken());
    //w = Integer.parseInt(st.nextToken());
    //num = Integer.parseInt(st.nextToken());

    //System.out.println("[n] : " + n);
    //System.out.println("[w] : " + w);
    //System.out.println("[num] : " + num);
  }
  private static void init(int n, int w, int num){

    int garo = (n % w == 0) ? n / w : n/w + 1; //22/6=3 3 + 1 = 4 //13/3 = 4 4+1
    //System.out.println("[num/w + 1] : " + (num/w + 1));
    int sero = w;

    //System.out.println("[garo] : " + garo);
    //System.out.println("[sero] : " + sero);
    arr = new int[sero][garo];
    boolean goup = false;

    for(int i = 0 ; i < garo; i++){//i = 0
      int startnum = (i+1) * sero; //3 6 9 12 
      if (! goup) {//아래로 증가
        for(int j = sero -1 ;j >= 0; j--){
          arr[j][i] = startnum;
          check(num, startnum, j, i);
          rollbackcauseofnum(n, startnum, i , j);
          startnum -= 1;
          
        }

        goup = true;
      }else{//위로 증가 goup == true
        for(int j = 0 ;j < sero; j++){
          arr[j][i] = startnum;
          check(num, startnum, j, i);
          rollbackcauseofnum(n, startnum, i , j);
          startnum -= 1;
        }

        goup = false;
      }
    }

    //디버깅 용
    /* 
    for(int i = 0 ; i < sero; i++){
      for(int j = 0 ; j < garo; j++){
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    */

  }
  private static void check(int num, int startnum, int j, int i){
    if (num == startnum){
            x = j;
            y = i;
          }
  }

  private static void rollbackcauseofnum(int n, int startnum, int i, int j){
      if (startnum > n)
            arr[j][i] = 0;
  }

  
}