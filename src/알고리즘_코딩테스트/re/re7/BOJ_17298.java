package 알고리즘_코딩테스트.re.re7;

import java.io.*;
import java.util.*;

public class BOJ_17298 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int n;
  static int arr[];
  static int max;

  public static void main(String[] args) throws Exception{
    input();
    for(int i = 0 ; i < n; i++){

    }

  }
  static void input() throws IOException{
    n = Integer.parseInt(bf.readLine());
    arr = new int[n];
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int i = 0;
    max = 1000000;
    while(i < n){
      arr[i] = Integer.parseInt(st.nextToken());
      i++;
    }

  }
}
