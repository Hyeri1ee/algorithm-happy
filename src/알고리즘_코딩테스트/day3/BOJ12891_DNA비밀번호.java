package 알고리즘_코딩테스트.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12891_DNA비밀번호 {
  static int P,S; //P : DNA 문자열 길이, S : 사용할 부분 문자열 길이
  static char[] dna;
  static int[] nes;

  public static void main(String[] args) throws IOException {
    input();
    int i = 0; int j = i+(S-1);
    int result = 0 ;

    while(j < P){
      int[] count = new int[4];
      for (int k = i; k < i+S; k++){
        if (dna[k] == 'A')
          count[0]++;
        else if (dna[k] == 'C')
          count[1]++;
        else if (dna[k] == 'G')
          count[2]++;
        else
          count[3]++;
//        switch(dna[k]){
//          case 'A' -> count[0]++;
//          case 'C' -> count[1]++;
//          case 'G' -> count[2]++;
//          case 'T' -> count[3]++;
//        }
      }
      if (Arrays.equals(nes, count)) {
        result++;
        i++; j++;
      }else{
        i++; j++;
      }
    }

    System.out.println(result);

  }
  static void input() throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    P = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    dna = bf.readLine().toCharArray();
    st = new StringTokenizer(bf.readLine());
    nes = new int[4];
    for (int i = 0  ; i < 4; i++)
      nes[i] = Integer.parseInt(st.nextToken());

  }
}
