package week1.day2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class P1158 {

  static StringBuilder SB = new StringBuilder();
  static Scanner sc  = new Scanner(System.in);
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();

    int n = sc.nextInt();
    int m = sc.nextInt();

    for (int i =0  ; i < n ;i++){
      queue.offer(i+1);
    }
    SB.append("<");
    int count = 0;
    while (count < n){
      doit(queue, m);
      if (count != n-1)
        SB.append(", ");
      else
        SB.append(">");
      count++;
    }

    System.out.println(SB);
  }

  private static void doit(Queue<Integer> queue, int m) {
    int i = 0;
    while (i < m-1)
    {
      int theone = queue.poll();
      queue.offer(theone);
      i++;
    }
    SB.append(queue.poll());
  }

}
