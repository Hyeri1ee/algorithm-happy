

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<int[]>[] adj ; // {도착노드, 비용}
    static int[] min;

    static int x, y;

    public static void main(String[] args) throws Exception{
        input();
        dk();
    }

    private static void dk(){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        min[x] = 0;
        pq.offer(new int[]{x, 0}); //{현재노드, 누적비용}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if (cost > min[node]) continue; //이미 더 짧은 경로 존재

            for (int[] next : adj[node]) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (min[nextNode] > cost + nextCost) {
                    min[nextNode] = cost + nextCost;
                    pq.offer(new int[]{nextNode, min[nextNode]});
                }
            }
        }
        System.out.println(min[y]);

    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for(int i=1; i<= n; i++){
            adj[i] = new ArrayList<>();
        }
        min = new int[n+1];
        Arrays.fill(min, Integer.MAX_VALUE);

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{b,v});
        }

        st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    }
}
