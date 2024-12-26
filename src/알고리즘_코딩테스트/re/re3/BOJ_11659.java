package 알고리즘_코딩테스트.re.re3;

import java.io.*;
import java.util.*;

public class BOJ_11659 {
  static StringBuilder sb = new StringBuilder();
  static int N,M;
  static int[] arr, sum;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    sum = new int[N];
    arr = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
    makeSumPortion();
    for (int i = 0 ; i < M ;i++){
      st = new StringTokenizer(bf.readLine());
      int a1, a2;
      a1 = Integer.parseInt(st.nextToken());
      a2 = Integer.parseInt(st.nextToken());
      if (a1-2 >= 0)
        sb.append(sum[a2-1] - sum[a1-2] +"\n");
      else
        sb.append(sum[a2-1]+"\n");

    }
    System.out.print(sb);

  }

  private static void makeSumPortion() {
    int init = 0;
    for (int i = 0 ; i < arr.length; i++){
      init += arr[i];
      sum[i] = init;
    }
  }
}
