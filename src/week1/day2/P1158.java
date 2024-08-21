package week1.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class P1158 {

  static StringBuilder sb = new StringBuilder();
  static BufferedReader sc  = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws Exception{
    Queue<Integer> queue = new LinkedList<>();
    StringTokenizer st = new StringTokenizer(sc.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for (int i =0  ; i < n ;i++){
      queue.offer(i+1);
    }
    sb.append("<");
    int count = 0;
    while (count < n){
      doit(queue, m);
      if (count != n-1)
        sb.append(", ");
      else
        sb.append(">");
      count++;
    }

    System.out.println(sb);
  }

  private static void doit(Queue<Integer> queue, int m) {
    int i = 0;
    while (i < m-1)
    {
      int theone = queue.poll();
      queue.offer(theone);
      i++;
    }
    sb.append(queue.poll());
  }

}
