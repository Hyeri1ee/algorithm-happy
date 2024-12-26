package old.week4.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2512 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int[] nums;
  static int N,M;

  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    nums = new int[N];
    int min = 100001;

    st = new StringTokenizer(bf.readLine());
    for (int i = 0 ; i < N; i++){

      nums[i] = Integer.parseInt(st.nextToken());
      if (min > nums[i])
        min = nums[i];
    }
    M = Integer.parseInt(st.nextToken());
    //end of input

    int max = (M - (N * min)) / N;
    int mid = (min + max) / 2;

    while (mid* N <= M){
      mid = (min + max) / 2;



    }

  }
}
