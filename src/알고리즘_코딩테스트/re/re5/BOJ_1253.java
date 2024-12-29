package 알고리즘_코딩테스트.re.re5;

import java.util.*;
import java.io.*;

public class BOJ_1253 {
  static int N;
  static long[] arr;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(bf.readLine());

    arr = Arrays.stream(bf.readLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();

    Arrays.sort(arr);

    int count = modifyCount();

    System.out.println(count);
    bf.close();

  }

  private static int modifyCount() {
    int count = 0;

    // N이 2 이하면 좋은 수가 될 수 없음
    if (N <= 2) return 0;

    for (int i = 0; i < N; i++) {
      int start = 0, end = N-1;
      long target = arr[i];

      while(start < end) {
        // 자기 자신을 제외
        if (start == i) {
          start++;
          continue;
        }
        if (end == i) {
          end--;
          continue;
        }

        long sum = arr[start] + arr[end];
        if (sum == target) {
          count++;
          break;
        } else if (sum > target) {
          end--;
        } else {
          start++;
        }
      }
    }
    return count;
  }
}
