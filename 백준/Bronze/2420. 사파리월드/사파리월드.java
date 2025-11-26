import java.io.*;
import java.util.*;



class Main {
  static long n, m;
  public static void main(String[] args) throws Exception{
    input();
    System.out.println(Math.abs(n-m));
  }
  private static void input() throws Exception{
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(bf.readLine());
      n = Long.parseLong(st.nextToken());
      m = Long.parseLong(st.nextToken());
  }
}
