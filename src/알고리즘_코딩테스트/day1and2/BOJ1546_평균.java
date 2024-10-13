package 알고리즘_코딩테스트.day1and2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1546_평균 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(bf.readLine());
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int num[] = new int[n];
    int max = 0;
    for (int i = 0 ; i < n; i++){
      int cur = Integer.parseInt(st.nextToken());
      if (max < cur)
          max = cur;
      num[i] = cur;
    }
    //평균 구하기
    double sum = 0;
    for (int i = 0 ; i < n; i++){
      sum += (num[i] * 100.0) / max;
    }
    System.out.println(sum/n);
  }
}
