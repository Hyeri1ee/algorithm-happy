
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int start, end;
    static int[] dist;//start에서 각 노드까지 가는 최소 비용 모아두기
    static ArrayList<Integer>[] path;
    static ArrayList<node>[] list;//비용 모아두기

    static final int MAX = 100_000_000;

    static class node {
        int w,stop;
        public node(int w, int stop){
            this.w = w;
            this.stop = stop;
        }
    }

    public static void main(String[] arg) throws Exception{
        input();

        solve();

        print();
    }
    private static void print(){
        StringBuilder sb = new StringBuilder();
        //최소 비용
        sb.append(dist[end]).append("\n");
        //거쳐야하는 도시 개수
        sb.append(path[end].size()).append("\n");
        //거쳐야하는 도시 방문 순서대로
        for(int next : path[end]){
            sb.append(next +" ");
        }
        System.out.println(sb);
    }
    private static void solve(){
        PriorityQueue<node> pq = new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.w - o2.w; //비용이 적은 순 = 우선순위
            }
        });
        //초기화
        dist[start] = 0;
        path[start].add(start);
        pq.add(new node(0, start));

        while(!pq.isEmpty()){

            node target = pq.poll();
            int cur = target.stop;

            if (dist[cur] < target.w) continue;//이미 짧은 경로 존재하므로 무시
            //현재 dist상태와 vs 현재까지의 + nodeStop까지 비용 비교

            for(node n : list[cur]){
                boolean checkIsNewPayIsSmaller= dist[n.stop] > dist[cur] + n.w;
                if (checkIsNewPayIsSmaller) {
                    dist[n.stop] = dist[cur] + n.w;
                    pq.add(new node( dist[n.stop], n.stop ));
                    //n.stop으로 가기 위해 거쳐야 하는 cur 노드 저장
                    path[n.stop] = new ArrayList<>(path[cur]);
                    path[n.stop].add(n.stop);
                }
            }


        }
    }
    private static void input() throws Exception{
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        list = new ArrayList[n+1];
        dist =new int[n+1];
        path = new ArrayList[n+1];

        //dist 초기화
        for(int i = 1; i <= n; i++){
            dist[i] = MAX;
        }

        //list 초기화
        for(int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
            path[i] = new ArrayList<>();
        }
        for(int i =0;i < m; i++){
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            list[from].add(new node(pay, to));
        }

        st = new StringTokenizer(bf.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        //디버깅
        /*
        for(int i = 1; i < n+1; i++){
           for(int j =0; j < list[i].size(); j++){
               System.out.print(list[i].get(j).stop);
           }
            System.out.println();
        }
        System.out.println("====");
        System.out.println("n : " + n);
        System.out.println("m : " + m);

         */
    }
}
