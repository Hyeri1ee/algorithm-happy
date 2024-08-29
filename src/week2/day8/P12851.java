package week2.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 고민중
public class P12851 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();

  static int [] visit = new int[100001];
  static int n, k;

  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    if (n == k)
    {
      sb.append("0\n1");
    }else{
      bfs();
    }

    System.out.println(sb);
  }
  public static void bfs() {
    Queue<Integer> q = new LinkedList<>();
    q.offer(n);
    visit[n] = 1; //방문 체크
    boolean first = true;
    int result = 0;
    while(!q.isEmpty()){
      int front = q.poll();
      for (int i = 0 ; i < 3 ;i++){
        int next;
        if (i == 0){
          next = front +1;
        }
        else if (i ==1){
          next = front -1;

        }
        else
          next = front * 2;

        //목표값 k와 같은지 확인
        if (next == k){
          int answer = 0;
          if (first)
          {
            first = false;
            result++;
            answer = visit[front];
            sb.append(answer);
          }else
          {
            if (answer == visit[front])
              result++;
          }
        }
        if (next >= 0 && next < visit.length && visit[next] == 0) {
          q.add(next);
          visit[next] = visit[front] + 1;
        }


      }

    }
  }
}
