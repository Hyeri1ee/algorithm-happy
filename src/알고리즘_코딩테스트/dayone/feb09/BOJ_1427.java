package 알고리즘_코딩테스트.dayone.feb09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1427 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    Integer[] arr = Arrays.stream(bf.readLine().split(""))
            .mapToInt(Integer::parseInt)
            .boxed()
            .toArray(Integer[]::new);
    Arrays.sort(arr, new Comparator<Integer>(){

      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });

    StringBuilder SB = new StringBuilder();
    for (int i = 0 ; i < arr.length; i++){
      SB.append(arr[i]);
    }
    System.out.println(SB);

  }
}
