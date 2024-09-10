package week4.day1;

import java.util.Scanner;

public class DP {
  static int[] answer;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    answer = new int[n+1];

    int result = fibonacci(n);
    System.out.println(result);
  }

  private static int fibonacci(int n){
    if (answer[n] != 0) return answer[n];
    if (n == 0){
      answer[n] = 0;
      return answer[n];
    }else if (n == 1){
      answer[n] = 1;
      return answer[n];
    }else {
      answer[n] = fibonacci(n-1) + fibonacci(n-2);
      return answer[n];
    }
  }

}
