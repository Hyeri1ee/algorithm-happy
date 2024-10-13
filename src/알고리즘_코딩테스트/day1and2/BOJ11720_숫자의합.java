package 알고리즘_코딩테스트.day1and2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11720_숫자의합 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  public static void main (String[] args) throws IOException {
    int n;
    n = Integer.parseInt(bf.readLine());
    char[] arr = bf.readLine().toCharArray();
    int sum = 0 ;
    for (int i = 0 ; i < n; i++)
    {
      sum += (int) (arr[i]-48);
    }
    System.out.println(sum);

  }
}
