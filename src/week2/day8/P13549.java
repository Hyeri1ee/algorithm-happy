package week2.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 고민중
public class P13549 {
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
      sb.append("0");
    }else{
      bfs();
    }

    System.out.println(sb);
  }
  public static void bfs() {
    Set<Integer> set = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    q.offer(n);
    visit[n] = 1; //방문 체크
    boolean flag = false; // 순간이동 여부
    while(!q.isEmpty()){
      int front = q.poll();
      for (int i = 0 ; i < 3 ;i++){
        int next;
        if (i == 0){
          flag = false;
          next = front +1;
        }
        else if (i ==1){
          flag = false;
          next = front -1;
        }
        else{
          flag = true;
          next = front * 2;
        }

        //목표값 k와 같은지 확인
        if (next == k){//단순히 같은지만 비교하면 안됨
          set.add(visit[front]);
        }
        if (next >= 0 && next < visit.length && flag == false) {
          q.add(next);
          visit[next] = visit[front] + 1;
        }
        if (next >= 0 && next < visit.length && flag == true) {
          q.add(next);
          visit[next] = visit[front];
        }
        if (next > k*2)
        {
          List<Integer> list = new ArrayList<>(set);
          Collections.sort(list);
          sb.append(list.get(list.size()-1));
          return;
        }


      }

    }
  }
}
