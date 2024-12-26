package old.week2.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 고민중
public class P12851 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  static int [] time = new int[100001];
  static int n, k;
  static int min = Integer.MAX_VALUE;
  static int count = 0;

  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    if (n >= k)//수빈이가 동생보다 더 앞에 있을 때
    {
      sb.append((n-k)+"\n1");
      System.out.println(sb);
      return;
    }else{
      bfs();
      System.out.println(min);
      System.out.println(count);
    }


  }
  public static void bfs() {
    Queue<Integer> que = new LinkedList<>();
    que.offer(n);
    time[n] = 1;
    while(!que.isEmpty()){
      int now = que.poll();

      if (min < time[now])
        continue;

      for (int i = 0 ; i <3 ;i++){
        int next;
        switch (i){
          case 0: next = now+1; break;
          case 1: next = now-1; break;
          default: next = now * 2; break;
        }
        if  (next < 0 || next > 100_000)
          continue;

        if (next == k){
          if (count == 0)
            min = time[now];
         if (time[now] == min)
           count++;
        }

        if (time[next] == 0 ||time[next] == time[now] + 1){//중복된 부분을 찾은 것
          que.offer(next);
          time[next] = time[now] + 1;
        }

      }
    }


  }//end of bfs
}//end of class
