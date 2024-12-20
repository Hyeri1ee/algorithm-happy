package 알고리즘_코딩테스트.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ11286_절댓값힙 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> renewQueue = new PriorityQueue<>((o1, o2) -> {
      int first_abs = Math.abs(o1);
      int second_abs = Math.abs(o2);

      if (first_abs == second_abs) {
        if (o1 == o2) return 0;
        return o1 > o2 ? 1 : -1;
      }
      else
        return first_abs-second_abs;
    });

    for (int i = 0 ; i < N; i++){
      int request = Integer.parseInt(br.readLine());
      if (request == 0){
        if (renewQueue.isEmpty())
          System.out.println("0");
        else
          System.out.println(renewQueue.poll());

      }else{
        renewQueue.add(request);
      }
    }
  }
}
