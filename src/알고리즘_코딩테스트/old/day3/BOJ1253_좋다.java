package 알고리즘_코딩테스트.old.day3;

import java.io.*;
import java.util.*;

public class BOJ1253_좋다 {
  static int N;
  static long[] arr;

  public static void main(String[] args) throws IOException {
    input();
    int result = 0;

    for (int k = 0 ; k < N ;k++){
      int i = 0;
      int j = N-1;
      long search = arr[k];
      while(i < j){
        if ((arr[i] + arr[j]) > search )
          j--;
        else if ((arr[i] + arr[j]) <search )
          i++;
        else//값이 같은 경우
        {
          if (((k != i) && (k != j))){
            result++;
            break;
          }else if (i == k)
            i++;
          else if (j == k)
            j--;
        }
      }
    }
    System.out.println(result);
  }
  private static void input() throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(bf.readLine());
    arr = new long[N];
    StringTokenizer st = new StringTokenizer(bf.readLine());

    for (int i = 0; i < N; i++)
      arr[i] = Long.parseLong(st.nextToken());
    Arrays.sort(arr);

  }
}
