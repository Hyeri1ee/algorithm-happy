
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int N,M;
  static int[][] arr;
  static int[][] sum;


  public static void main(String[] args)  throws IOException {
    input();
    //Arrays.fill(sum, 0);
    rangeSum();
    for (int i = 0 ; i < M; i++){
      sb.append(Integer.toString(semiInput()));
      sb.append("\n");
    }
    System.out.println(sb);

  }
  private static void rangeSum(){
    for (int i = 1; i < N+1; i++){
      for (int j = 1 ; j < N+1;j++){
        sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + arr[i][j];
      }
    }
  }

  private static void input()  throws IOException{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    arr = new int[N+1][];
    sum = new int[N+1][];
    for (int i = 0 ; i  < N+1; i++){
      arr[i] = new int[N+1];
      sum[i] = new int[N+1];

    }
    for (int i=1; i<N+1;i++){
      st = new StringTokenizer(bf.readLine());
      for (int j = 1 ;  j < N+1; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }


  }

  private static int semiInput() throws IOException{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int a1,a2,b1,b2;
    a1 = Integer.parseInt(st.nextToken());
    a2= Integer.parseInt(st.nextToken());
    b1 = Integer.parseInt(st.nextToken());
    b2 = Integer.parseInt(st.nextToken());
    int result = sum[b1][b2]- sum[a1-1][b2] - sum[b1][a2-1] + sum[a1-1][a2-1];
    return result;
  }

}