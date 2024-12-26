package old.week3.day6;

import java.util.Scanner;

public class P2661 {
  static Scanner sc = new Scanner(System.in);
  static int n;
  static StringBuilder sb = new StringBuilder();
  static String answer = "";
  public static void main(String[] args) {
    n = sc.nextInt();
    dfs("");
    System.out.println(answer);

  }
  private static void dfs(String str){
    if (answer != "") return;
    if (str.length() == n){
      answer = str;
      return;
    }
    for (int i =1 ; i <=  3; i++){//123 중 하나씩 넣어서 좋은 수열인지 판별
      if (check(str+i))
        dfs(str+i);
    }
  }
  public static boolean check(String value){
    for(int i=1;i<=value.length()/2;i++) {//비교할 문자열 수
      for(int j=0;j<=value.length()-i*2;j++) {
        if(value.substring(j,j+i).equals(value.substring(j+i,j+i*2))) return false;
      }
    }
    return true;
  }
}
