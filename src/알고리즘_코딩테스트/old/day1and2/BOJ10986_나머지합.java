package 알고리즘_코딩테스트.old.day1and2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10986_나머지합 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int []arr;
  static int[] sum;
  static int N,M;
  public static void main(String[] args) throws IOException {
    input();
    int result = 0;
    for (int i = 1  ; i< N+1 ;i++){
      for (int j = 0 ; j< i ;j++){
        int partial = sum[i]-sum[j];
        if ((partial % M) == 0)
          result++;
      }
    }
    System.out.println(result);
  }

  private static void input() throws IOException {
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N+1];
    sum = new int[N+1];
    st = new StringTokenizer(bf.readLine());
    for (int i = 1 ; i  < N+1; i++){
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = sum[i-1] + arr[i];
    }
  }
}
