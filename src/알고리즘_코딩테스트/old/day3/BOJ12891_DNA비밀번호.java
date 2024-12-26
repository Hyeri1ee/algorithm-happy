package 알고리즘_코딩테스트.old.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891_DNA비밀번호 {
  static int P,S; //P : DNA 문자열 길이, S : 사용할 부분 문자열 길이
  static char[] dna;// DNA 전체 문자 배열
  static int[] check;// 필요한 최소 ACGT 개수 배열
  static int[] cur; // 현재 상태 배열 : 각 ACGT 원소의 개수 저장 배열
  static int checkSecret = 0; //만족한 문자 개수 판단 변수 (4가 되면, 다 만족한 것)


  public static void main(String[] args) throws IOException {
    input();
    int result = 0;
    //초기 만족 여부 판단
    for(int i = 0  ; i < S; i++){
      add(dna[i]);
    }
    if (checkSecret == 4)
      result++;
    //그 이후에는 맨앞 원소 remove, 맨뒤 원소 add로 판단
    //i = 두번째 인덱스, j = 첫번째 인덱스
    for (int i = S; i < P; i++){
      int j = i-S;
      add(dna[i]);
      remove(dna[j]);
      if (checkSecret == 4)
        result++;

    }
    System.out.println(result);


  }

  private static void add(char c) {
    switch(c){
      case 'A':
      {
        cur[0]++;
        if (cur[0] == check[0])
          checkSecret++;
        break;
      }
      case 'C':
      {
        cur[1]++;
        if (cur[1] == check[1])
          checkSecret++;
        break;
      }
      case 'G':
      {
        cur[2]++;
        if (cur[2] == check[2])
          checkSecret++;
        break;
      }
      case 'T':
      {
        cur[3]++;
        if (cur[3] == check[3])
          checkSecret++;
        break;
      }
    }
  }

  private static void remove(char c) {
    switch(c){
      case 'A':
      {
        if (cur[0] == check[0])
          checkSecret--;
        cur[0]--;
        break;
      }
      case 'C':
      {
        if (cur[1] == check[1])
          checkSecret--;
        cur[1]--;
        break;
      }
      case 'G':
      {
        if (cur[2] == check[2])
          checkSecret--;
        cur[2]--;
        break;
      }
      case 'T':
      {
        if (cur[3] == check[3])
          checkSecret--;
        cur[3]--;
        break;
      }
    }
  }


  static void input() throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    P = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    dna = bf.readLine().toCharArray();
    st = new StringTokenizer(bf.readLine());
    check = new int[4];
    cur = new int[4];
    for (int i = 0  ; i < 4; i++){
      check[i] = Integer.parseInt(st.nextToken());
      if (check[i]== 0)
        checkSecret++;
    }

  }
}
