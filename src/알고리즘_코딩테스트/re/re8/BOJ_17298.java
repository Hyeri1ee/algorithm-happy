package 알고리즘_코딩테스트.re.re8;

import java.util.*;
import java.io.*;
class Point{
  int index;
  int cost;

  public Point(int index, int cost) {
    this.index = index;
    this.cost = cost;
  }
}
public class BOJ_17298 {
  static int n;
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int[] answer;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    Stack<Point> input = new Stack<>();

    answer = new int[n];
    Arrays.fill(answer,-1);

    int num = 0;
    Point[] map = new Point[n];
    String[] s1 = br.readLine().split(" ");
    for (int i = 0 ; i < n; i++){
      map[i] = new Point(i, Integer.parseInt(s1[i]));
    }

    for (Point now : map){
      while(!input.isEmpty() && input.peek().cost<now.cost){//오른쪽 수가 더 큰 경우
        answer[input.pop().index] = now.cost;
      }
      input.add(now);//처음엔 자기 자신 push
    }

    StringBuilder sb = new StringBuilder();
    for(int i=0; i<n; i++){
      sb.append(answer[i]).append(" ");
    }

    System.out.println(sb.toString());
  }

}
