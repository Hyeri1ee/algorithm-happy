package 알고리즘_코딩테스트.re.re6;

import java.util.*;
import java.io.*;
public class BOJ_12891{
  static int[] PassWord = new int[4]; // 비밀번호 규칙
  static int[] MyPassWord = new int[4]; // 내가 직접 마주하는 임시 비밀번호 규칙
  static int count;
  public static void main(String[] args) throws IOException {
    int result = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int length = Integer.parseInt(st.nextToken()); // 총 문자열길이
    int range = Integer.parseInt(st.nextToken()); // 만드는 비밀번호 길이
    char[] Dna;
    Dna = br.readLine().toCharArray(); // 들어오는 총 문자열 길이
    st = new StringTokenizer(br.readLine()); // 1 0 0 1 비밀번호 저장.
    for(int i=0; i<4;i++){
      PassWord[i] = Integer.parseInt(st.nextToken()); // 1 0 0 1 비밀번호를 PassWord배열에 넣음

      if(PassWord[i] == 0){ // 비밀번호가 1 0 0 1일때 0이 들어갈때마다 count++증가.
        count++; // 기본 카운터는 2가 될 것 임.
      }
    }


    for(int i=0; i<range;i++){ // range = 2기 때문에 2번 반복
      Add(Dna[i]); //각 배열을 비교하는 Add함수 사용
      //GA의 경우는 1 0 1 0 임으로 1 0 0 1과 다르기때문에 count 값은 3이 됨.
    }
    if(count==4) result++;

    //이제 GA를 한번 확인 했으니
    //이 다음 확인부터는 윈도우 슬라이딩을 이용 할 것임.
    //이 FOR문은 윈도우 슬라이딩 반복문임.
    for(int j=range;j<length;j++){
      int start = j-range;
      int end = j;
      Add(Dna[end]); //GA를 위에서 검증했고 AT를 검증할 차례 하지만 A는 이미 검증되었음으로 확인 X
      Remove(Dna[start]); //윈도우 슬라이딩임으로 GA -> AT로 넘어가야 하기 떄문에 G의 값을 삭제 시켜준다.
      if(count==4) result++;
    }
    System.out.println(result);
  }


  public static void Remove(char c){

    switch(c){
      case 'A': {
        if(MyPassWord[0]==PassWord[0]){
          count--;
        }
        MyPassWord[0]--;
        break;
      }
      case 'C': {
        if(MyPassWord[1]==PassWord[1]){
          count--;
        }
        MyPassWord[1]--;
        break;
      }
      case 'G':{
        //GA값은 1 0 1 0 이였다. 1 0 0 1 값과 비교한다.
        //G의 자리 수를 서로 비교함. 1 , 0임으로 if는 false
        if(MyPassWord[2]==PassWord[2]){
          count--;
        }
        MyPassWord[2]--;
        break;
      }
      case 'T':{
        if(MyPassWord[3]==PassWord[3]){
          count--;
        }
        MyPassWord[3]--;
        break;
      }
    }

  }
  public static void Add(char c){ //GA , AT , TA가 들어올 것 임.

    switch(c){
      case 'A':{
        MyPassWord[0]++;
        if(MyPassWord[0]==PassWord[0]) {
          count++;
        }
        break;
      }
      case 'C':{
        MyPassWord[1]++;
        if(MyPassWord[1]==PassWord[1]){
          count++;
        }
        break;
      }
      // 0 0 0 0과 1 0 0 1 비밀번호 비교
      case 'G':{
        MyPassWord[2]++;
        //G가 들어오면 G자리에 1을 추가.
        //그 후 비밀번호가 자리 값이 같은지 비교
        if(MyPassWord[2]==PassWord[2]){
          count++;
        }
        break;
      }
      case 'T':{
        MyPassWord[3]++;
        if(MyPassWord[3]==PassWord[3]){
          count++;
        }
        break;
      }
    }
  }
}