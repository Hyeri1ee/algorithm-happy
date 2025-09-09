import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static ArrayList<Integer>[] list;

    static PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    public static void main(String[] args)throws Exception{
        input();

        for(int i = 1; i < n + 1; i++){
            q.add(new int[] {i, bfs(i)});
        }


        //print
        int[] finalDepth = q.poll();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(finalDepth[0]);
        for(int[] a : q){
            if (a[1] == finalDepth[1])
            {
                result.add(a[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(finalDepth[1] +" " + result.size()+"\n");
        Collections.sort(result);
        for(int i : result)
            sb.append(i +" ");

        System.out.println(sb);
    }

    static int bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);

        que.add(start);
        dist[start] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int nxt : list[cur]) {
                if (dist[nxt] == -1) {//방문 안 한 곳
                    dist[nxt] = dist[cur] + 1;
                    que.add(nxt);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        list = new ArrayList[n+1];
        for(int i = 0 ; i < n; i++){
            list[i+1] = new ArrayList<>();
        }

        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b==-1)
                break;
            list[a].add(b);
            list[b].add(a);
        }
    }
}
