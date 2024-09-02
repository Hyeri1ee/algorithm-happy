package week2.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 고민중
public class P13549 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  static int [] time = new int[100001];
  static int n, k;
  static int min = Integer.MAX_VALUE;
  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    if (n >= k)
    {
      sb.append((n-k) + "");
    }else{
      bfs();
    }

    System.out.println(sb);
  }
  public static void bfs() {
    Queue<Integer> que = new LinkedList<>();
    que.offer(n);
    time[n] = 1;
    while(!que.isEmpty()){
      int next = 0;
      int now = que.poll();
      for (int i =0  ; i <3 ;i++){
        if (next > 100001 || next < 0)
          continue;
        if (min < time[now])
          continue;

        switch (i){
          case 0: next= now +1; break;
          case 1: next = now-1; break;
          default: next = now * 2; break;
        }//end of switch
        if (next == k){
          min = time[now];
        }
        if (time[next] == 0 || time[next] == time[now] + 1){//중복된 부분을 찾은 것
          que.offer(next);
          time[next] = time[now] + 1;
        }
        if (time[next] == 0 || time[next] == time[now] + 0){//중복된 부분을 찾은 것
          que.offer(next);
          time[next] = time[now];
        }

      }//end of for
    }//end of while


  }//end of bfs

}//end of class
