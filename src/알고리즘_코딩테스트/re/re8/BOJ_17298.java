package 알고리즘_코딩테스트.re.re8;

import java.util.*;
import java.io.*;

public class BOJ_17298 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int[] arr;
  public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(bf.readLine());
    arr = new int[n];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    for (int i = 0 ; i < n ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    //
  }

}
