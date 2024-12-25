package 알고리즘_코딩테스트.re.two;

import java.io.*;
import java.util.*;

public class BOJ_1546 {

  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] arr = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
    int max = 0;
    int sum = 0;
    for (int i = 0 ; i < N; i++){
      if (max < arr[i])
        max = arr[i];
      sum += arr[i];
    }
    System.out.printf("%.2f", (sum*100.0/max) / N);
  }
}
