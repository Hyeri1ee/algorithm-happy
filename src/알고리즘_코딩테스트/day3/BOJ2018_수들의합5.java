package 알고리즘_코딩테스트.day3;

import java.util.Scanner;

public class BOJ2018_수들의합5 {
  public static void main(String[] args) {
    Scanner sc =  new Scanner(System.in);
    int N = sc.nextInt();
    int start =1, end=1;
    int sum = 1;
    int result = 1;

    while(end < N){
      if (sum > N)
      {
        sum = sum - start;
        start++;
      }else if (sum < N){
        end++;
        sum = sum + end;
      }else if (sum == N){
        end++;
        sum = sum + end;
        result++;
      }
    }

    System.out.println(result);
  }
}
