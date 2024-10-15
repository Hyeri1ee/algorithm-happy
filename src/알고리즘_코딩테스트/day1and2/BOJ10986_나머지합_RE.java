package 알고리즘_코딩테스트.day1and2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ10986_나머지합_RE {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();
    long[] S = new long[N];
    long[] C = new long[M];
    long answer = 0;
    S[0] = sc.nextInt();
    for (int i=1; i <N; i++){//수열의 합 배열 만들기
      S[i] = S[i-1]+sc.nextInt();
    }
    for (int i=0; i<N;i++){
      int remainder = (int) (S[i] % M);
      if (remainder == 0) answer++;
      C[remainder]++;//나머지 같은 인덱스 개수 카운팅하기
    }
    for (int i = 0 ; i <M;i++){
      if (C[i] > 1){//나머지가 같은 수가 2개 이상 있는 것이므로, 이들 중에서 2개 고르는 경우의 수를 구함
        answer = answer + (C[i] *(C[i]-1) / 2);
      }
    }
    System.out.println(answer);
  }
}
