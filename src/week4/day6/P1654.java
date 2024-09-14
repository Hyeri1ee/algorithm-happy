package week4.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1654 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int[] lines;
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int k = Integer.parseInt(st.nextToken());//이미 가진 랜선 개수
    int n = Integer.parseInt(st.nextToken());//필요한 랜선의 개수
    lines = new int[k];

    long min = 0, max = 0, mid = 0;
    for (int i = 0 ; i < k ;i++){
      st = new StringTokenizer(bf.readLine());
      lines[i] = Integer.parseInt(st.nextToken());
      if (max < lines[i])
        max = lines[i];
    }//end of input

    max++;
    long sum = 0;//
    while(min < max){
      sum = 0;
      mid = (max + min) / 2;
      for (int i = 0 ; i < k ;i++){
        sum += lines[i] / mid;
      }
      if (sum < n){
        max = mid;
      }else//sum > n
        min = mid +1;
    }
    System.out.println(min-1);

  }
}
