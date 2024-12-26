package old.week4.day5;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {
  static BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
  static int[] woods;
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    woods = new int[N];
    st = new StringTokenizer(bf.readLine());
    int max = 0;
    for (int i = 0 ; i <N ;i++){
      woods[i] = Integer.parseInt(st.nextToken());
      if (woods[i] > max)
        max = woods[i];
    }//end of input

    int min = 0;
    int mid;
    while(min < max){
      mid = (min + max) / 2;
      long sum = 0;
      for (int height : woods){
       if(height - mid > 0){
         sum += height - mid;
       }
      }
      if (sum < M)
        max = mid;
      else
        min = mid + 1;
    }
    System.out.println(min-1);
  }

}
