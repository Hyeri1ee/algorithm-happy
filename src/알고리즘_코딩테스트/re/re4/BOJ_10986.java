package 알고리즘_코딩테스트.re.re4;

import java.io.*;
import java.util.*;

/*
1 2 3 1 2
1 2 0 1 2
 */
public class BOJ_10986 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[] arr, sum;

  public static void main(String[] args) throws IOException {
    initialize();

    int count = 0;
    int[] countArr = new int[M];

    for (int i = 0; i < N; i++) {
      if (sum[i] == 0)
        countArr[0] += 1;
      else {//나누어 떨어지지 않은 경우
        countArr[sum[i]] += 1;
      }
    }

    count += countArr[0];//나머지가 0인 개수
    for (int i = 1 ; i < N/2; i++){
      count += combination(countArr[i],countArr[N-1-i]);
    }

    System.out.println(count);
  }

  private static int combination(int i, int i1) {
    return i * i1 / 2;
  }

  private static void initialize() throws IOException {
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N];
    sum = new int[N];
    arr = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
    sum[0] = arr[0] % M;

    for (int i = 1; i < N; i++) {
      sum[i] = (sum[i - 1] + arr[i]) % M;
    }
  }
}
