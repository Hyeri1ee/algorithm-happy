
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, v;
    static boolean visited[];
    static ArrayList<Integer> edge [];

    public static void main(String[] args) throws IOException{
        //정점개수 n, 간선개수 m, 탐색을 시작할 정점 번호 v 입력, visted 배열 정의
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        edge = new ArrayList[n+1];

        //간선 초기화
        for (int i = 1; i < n+1 ; i++){
            edge[i] = new ArrayList<>();
        }

        //간선 정보 입력
        for (int i = 0 ; i < m ;i++ ){
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edge[node1].add(node2);
            edge[node2].add(node1);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(edge[i]);
        }

        //dfs - 재귀로 구현
        dfs(v);

        //visited 배열 초기화
        Arrays.fill(visited, false);
        sb.append("\n");

        //bfs - 큐로 구현
        Queue<Integer> queue = new LinkedList<>();
        bfs(v,queue);

        System.out.println(sb);
    }

    private static void dfs(int start){
        if (visited[start])
            return;
        visited[start] = true;
        sb.append(start +" ");
        for (int node : edge[start]){
            if (!visited[node]){//start 옆에 있는 . 중에 방문하지 않은 노드이면 방문 표시후, dfs 돌리기
                dfs(node);
            }
        }

    }

    private static void bfs(int start, Queue<Integer> queue){
        visited[start] = true;
        queue.add(start);
        sb.append(start +" ");

        while(!queue.isEmpty()){
            int pop = queue.poll();
            for (int node : edge[pop]){
                if (!visited[node]){
                    visited[node] = true;
                    sb.append(node + " ");
                    queue.add(node);
                }
            }
        }
    }


}
