package 알고리즘_코딩테스트.re.re5;

import java.util.*;
import java.io.*;

public class BOJ_2018 {
  static long N;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException{
    initialize();
    long count = 0;
    long start = 1, end = 1;
    long sum = 1;
    while(start <= end && start <= N){
      if (sum == N){
        count++;
        sum -= start;
        start++;
        if (end < N){
          end++;
          sum += end;
        }
      }else if (sum >N){
        sum -= start;
        start++;
      }else{//sum < N
        end++;
        if (end <= N){
          sum += end;
        }
      }
    }

    System.out.println(count);


  }
  private static void initialize() throws IOException{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Long.parseLong(st.nextToken());

  }
}
