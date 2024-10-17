package 알고리즘_코딩테스트.day3;

import java.io.*;
import java.util.*;
/*
Di = 구간의 크기가 L로 정해져 있는 곳에서 최솟값
 */

public class BOJ11003_최솟값찾기 {

  class myDeque{
    int index;
    int value;

    public myDeque(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  static int N,L;
  static Deque<myDeque> dequeList[] = new Deque<>();
  static int result[];
  public static void main(String[] args) throws IOException{
    //입력값 받기
    input();

  }
  private static void input() throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    result = new int[N];
    st = new StringTokenizer(bf.readLine());

    for (int i = 0  ; i < N;  i++){
      A[i] =  Integer.parseInt(st.nextToken());
    }

  }
}
