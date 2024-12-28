package 알고리즘_코딩테스트.re.re4;

import java.io.*;
import java.util.*;

public class BOJ_11660 {
  static class XY {
    int x1, y1, x2, y2;

    public XY() {

    }
  }

  static int N, M;
  static int[][] arr, sum;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    //값 받기 및 static 변수 초기화
    initialize();
    //출력
    getInputAndOutcome();

  }

  private static void getInputAndOutcome() throws IOException {
    XY[] inputs = new XY[M];
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(bf.readLine());
      inputs[i] = new XY();
      int x1 = inputs[i].x1 = Integer.parseInt(st.nextToken());
      int y1 = inputs[i].y1 = Integer.parseInt(st.nextToken());
      int x2 = inputs[i].x2 = Integer.parseInt(st.nextToken());
      int y2 = inputs[i].y2 = Integer.parseInt(st.nextToken());

      //결과
      int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
      sb.append(result + "\n");

    }
    System.out.println(sb);
  }

  static private void initialize() throws IOException {
    arr = new int[N + 1][];
    sum = new int[N + 1][];

    arr[0] = new int[N + 1];
    sum[0] = new int[N + 1];
    for (int i = 1; i < arr.length; i++) {
      arr[i] = new int[N + 1];
      sum[i] = new int[N + 1];
      int[] temparr = Arrays.stream(bf.readLine().split(" "))
              .mapToInt(Integer::parseInt)
              .toArray();
      int index = 0;
      for (int j = 1; j < arr[i].length; j++) {
        arr[i][j] = temparr[index];
        index++;
        //sum배열 초기화
        if (i == 1 && j == 1)
          sum[i][j] = arr[i][j];
        else
          //구간합
          sum[i][j] = sum[i][j-1] + +sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
      }
    }
    //debug
//    for (int i = 1 ; i < arr[1].length; i++){
//      System.out.print(arr[1][i] +" ");
//    }

  }//end of initialize

}
