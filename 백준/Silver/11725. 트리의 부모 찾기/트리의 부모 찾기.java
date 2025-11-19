import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int n;
    static LinkedList<Integer>[] graph;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        input();
        solve();
    }
    private static void solve(){

        bfs(1);

    }
    private static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next : graph[cur]){
                if(!visited[next]){
                    visited[next] = true;
                    parent[next] = cur;//부모 갱신
                    queue.add(next);
                }
            }
        }

        for(int i = 2 ; i <= n ; i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        parent = new int[n+1];
        IntStream.range(0, parent.length)
                .forEach(i -> parent[i] = i);
        graph = new LinkedList[n+1];
        for(int i = 0 ; i < graph.length ; i++){
            graph[i] = new LinkedList<>();
        }

        StringTokenizer st;
        for(int i = 1 ; i  < n ;i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
    }

    
}
