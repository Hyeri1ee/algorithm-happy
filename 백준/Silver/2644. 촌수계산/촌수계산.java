

import java.io.*;
import java.util.*;

/*
부모와 자식 사이를 1촌으로 정의
n
x y
m
m번의 부모 자식간의 관계를 나타내는 두 번호 (부모/자식)
 */
public class Main {
    static int n, x, y, m;
    //static int[] ms;
    static List<Integer>[] ms;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        input();
        int ans = bfs(x, y);
        System.out.println(ans);


    }
    private static int bfs(int start, int t){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        dist = new int[n+1];

        q.add(start);
        visited[start] = true;
        dist[start] = 0;//dist[i] = start에서 i까지의 촌수 거리

        while(!q.isEmpty()){
            int cur = q.poll();
            if (cur == t)
                return dist[cur];

            for(int nxt : ms[cur]){
                if (!visited[nxt]){
                    visited[nxt] = true;
                    dist[nxt] = dist[cur] + 1;
                    q.add(nxt);
                }
            }
        }

        return -1;
    }
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(bf.readLine());
        ms = new ArrayList[n+1];
        //초기화
        for (int i = 1; i <= n; i++) ms[i] = new ArrayList<>();

        for(int i = 0 ; i < m ; i++)
        {

            st = new StringTokenizer(bf.readLine());
            //부모 자식
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ms[x].add(y);
            ms[y].add(x);//양방향
        }
    }
}
