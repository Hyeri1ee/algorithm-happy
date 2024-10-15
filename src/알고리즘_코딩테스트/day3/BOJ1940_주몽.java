package 알고리즘_코딩테스트.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1940_주몽 {
  static int N,M;
  static int[] arr;
  public static void main(String[] args) {
    int n = input();
    System.out.println(n);
  }
  static int input(){
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    arr = new int[N];
    for (int i = 0 ; i <N; i++)
    {
      arr[i] = sc.nextInt();
    }//입력 받기
    Arrays.sort(arr);
    int result = 0;
    int i = 0, j = N-1;
    while(i < j){
      if (arr[i] + arr[j] < M){
        i++;
      }else if (arr[i] + arr[j] > M) {
        j--;
      }else{//같은 경우
        result++;
        i++;
        j--;
      }
    }
    return result;
  }
}
