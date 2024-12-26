package old.week6.day1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10815 {
  static int N, M;
  static int[] NArray;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine()); //상근이의 카드

    NArray = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i++){
      NArray[i] = Integer.parseInt(st.nextToken()); //상근 카드 요소
    }

    Arrays.sort(NArray); //이진탐색 정렬

    M = Integer.parseInt(br.readLine()); //기준 카드 개수(비교)

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < M; i++){
      int num = Integer.parseInt(st.nextToken());

      bw.write(BinarySeach(num) + " ");
    }
    br.close();
    bw.flush();
    bw.close();
  }

  public static int BinarySeach(int num){
    int left = 0;
    int right = N-1;

    while(left <= right){
      int middle = (left + right)/2;
      int middleValue = NArray[middle];

      if(num > middleValue){
        left = middle +1;
      }else if(num < middleValue){
        right = middle -1;
      }else return 1;//찾은경우
    }
    return 0; //못 찾은 경우
  }
}