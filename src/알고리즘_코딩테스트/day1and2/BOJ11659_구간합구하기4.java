package 알고리즘_코딩테스트.day1and2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659_구간합구하기4 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(bf.readLine());

    int N,M;
    int[] sum;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    sum = new int[N];
    st = new StringTokenizer(bf.readLine());
    for (int i = 0 ; i < N;i++){
      if (i==0)
        sum[i] = Integer.parseInt(st.nextToken());
      else
        sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
    }

    for (int i = 0 ; i < M; i++){
      st = new StringTokenizer(bf.readLine());
      int a, b;
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      if (a == 1)
          sb.append(Integer.toString(sum[b-1] - 0));
      else
          sb.append(Integer.toString(sum[b-1]- sum[a-2]));
      sb.append("\n");
    }

    System.out.println(sb);


  }
}
