import java.io.*;
import java.util.*;

public class Main {
   
  static int n;

  static long code1, code2;
  static int[] dp;

  public static void main(String[] args) throws Exception{
    input();
    solve();

  }
  private static long recur(int s){
     
    //System.out.println("[recur]" + ": " + s);
    if (s <= 2) {
      code1++;
      return 1;
    }
    
    return recur(s-1) + recur(s-2);
  }
  private static void dp(int s){//s는 적어도 3이상
    while(s <= n){
      //System.out.println("[dp]" + ": " + s);
      code2++;
      dp[s] = dp[s-1] + dp[s-2];
      s++;
    }

    //return code2;
      

  }
  private static void solve() {
    recur(n);
    dp(3);
    System.out.println(code1 + " " + code2);
  }
  private static void input() throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(bf.readLine());
    //System.out.println(n);
    dp = new int[n+1]; dp[1]=dp[2]=1; 
  }
}
