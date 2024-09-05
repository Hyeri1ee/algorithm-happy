package week3.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int result, N,S, count;
  static int[] arr;

  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());
    arr = new int[N];
    for (int i = 0 ; i < N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }//입력 받기 완료
    count = 0 ;

    dfs(0,0);

    System.out.println(S == 0 ? count - 1 : count); //문제 조건에서 크기가 양수인 부분수열을 배경으로 했으므로, dfs로 구한 결과에서 공집합이 포함되어있기 때문에 제외시켜야함
  }

  private static void dfs(int index, int sum){
    if (index == N){
      if (sum == S){
        count++;
      }
      return;
    }//end of if
    dfs(index+1, sum + arr[index]); //현재 index 를 포함했을때
    dfs(index+1, sum); //현재 index 를 포함하지 않았을때
  }
}
