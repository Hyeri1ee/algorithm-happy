
import java.util.*;
import java.io.*;

public class Main {
  static int N,M;
  static int[] arr;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws  IOException{
    N = Integer.parseInt(bf.readLine());
    M = Integer.parseInt(bf.readLine());

    arr = Arrays.stream(bf.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

    Arrays.sort(arr);

    int count = 0;

    int i = 0, j = N-1;
    while(i < j){
      if (arr[i] + arr[j] < M){
        i++;
      }else if (arr[i] + arr[j] > M){
        j--;
      }else{// ==
        count++;
        i++;
        j--;
      }
    }
    System.out.println(count);
    bf.close();

  }
}
