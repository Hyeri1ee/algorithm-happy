

import java.io.*;
import java.util.*;

public class Main {
    static class node implements Comparable<node>{
        int num, value;
        public node(int num, int value){
            this.num = num;
            this.value = value;
        }

        @Override
        public int compareTo(node o) {
            return this.value - o.value;
        }
    }
    static int v, e;
    static int start;
    static List<node>[] list;
    static int[] dist;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        list = new ArrayList[v+1];
        dist = new int[v+1];

        Arrays.fill(dist, 100_000_000);
        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0; i< e; i++){
            st  = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new node(v, w));
        }

        //
        StringBuilder sb = new StringBuilder();
        다익스트라(start);
        for(int i =0 ; i < v; i++){
            if (dist[i+1] == 100_000_000) sb.append("INF\n");
            else sb.append(dist[i+1] + "\n");
        }
        System.out.println(sb);




    }

    private static void 다익스트라(int k){
        PriorityQueue<node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        queue.add(new node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            node pop = queue.poll();
            int cur = pop.num;
            if (check[cur]) continue;
            check[cur] = true;

            for(node n : list[cur]){
                if (dist[n.num] > dist[cur] + n.value){
                    dist[n.num] =  dist[cur] + n.value;
                    queue.add(new node(n.num, dist[n.num]));
                }
            }
        }

    }
}
