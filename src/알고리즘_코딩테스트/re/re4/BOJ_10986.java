package 알고리즘_코딩테스트.re.re4;

import java.io.*;
import java.util.*;

/*
1 2 3 1 2
1 2 0 1 2
 */
public class BOJ_10986 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static long N, M;
  static long[] arr, sum;

  public static void main(String[] args) throws IOException {
    initialize();

    long count = 0;
    long[] countArr = new long[(int) M];

    for (int i = 0; i < N; i++) {
      if (sum[i] == 0)
        countArr[0]++;
      else {//나누어 떨어지지 않은 경우
        countArr[(int) sum[i]]++;
      }
    }

    count += countArr[0];//나머지가 0인 개수
    for (int i = 0 ; i < M; i++){
      count += combination(countArr[i]);
    }

    System.out.println(count);
  }

  private static long combination(long i) {
    return (i * (i-1)) / 2;
  }

  private static void initialize() throws IOException {
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new long[(int) N];
    sum = new long[(int) N];
    arr = Arrays.stream(bf.readLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();
    sum[0] = arr[0] % M;

    for (int i = 1; i < N; i++) {
      sum[i] = (sum[i - 1] + arr[i]) % M;
    }
  }
}