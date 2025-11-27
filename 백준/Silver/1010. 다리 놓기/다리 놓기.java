/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;


/*
n번만큼 1x    m , m-1, m-2,....을 곱하면 됨

다리끼리는 서로 겹칠 수 없음

n , n-1, n-2, ...1 만큼 나누기

 */

class Main {
   static int n, m;
   static Scanner sc = new Scanner(System.in);
   static StringBuilder sb= new StringBuilder();

  public static void main(String[] args) throws Exception{
    int t = sc.nextInt();
    while(t-- > 0){
      input();
      long value = solve();
      
      sb.append(value + "\n");
    }
    
    System.out.println(sb);
    sc.close();
    
  }
  private static long  solve(){//각각 계산하면 long을 넘어감
//mCn
    long result = 1;
    long bottom = 1;

    for(int i =0; i<n ;i++){
      //System.out.println("[i] : " + i);
      result *= (m-i);
      result /= (i+1);
      //System.out.println("[result] : " + result);
      //System.out.println("[bottom] : " + bottom);
    }


    

    return result;
  }
  private static void input() throws Exception{
    
    n = sc.nextInt();
    m = sc.nextInt();
    //System.out.println("n, m : " + n  +  " , " +m);
    
  }
}