package 알고리즘_코딩테스트.dayone.feb09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11399 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(bf.readLine());
    int[] arr = new int[n];
    arr = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    Arrays.sort(arr);
    int result = arr[0];

    for (int i = 1 ; i < arr.length ;i ++){
      int temp = arr[i];
      arr[i] = arr[i-1] + temp;
      result += arr[i];
    }

    System.out.println(result);

  }
}
