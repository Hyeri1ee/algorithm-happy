package alkon_challenge.helloalkon;

import java.io.*;
import java.util.*;

/*
모든
$\left(i, j\right)$쌍에 대해서
$\left(1 \lt i \lt j\leq N\right)$, 정점
$1$에서 정점
$i$로의 최단 경로의 비용이 정점
$1$에서 정점
$j$로의 최단 경로의 비용보다 작아야 한다.

 */
public class F {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static ArrayList<Integer>[] edge;
    static int dist[];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edge = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            edge[i] = new ArrayList<>();
        }

        dist = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            edge[a].add(b);
            edge[b].add(a);
        }

        bfs();

        boolean valid = true;
        for (int i = 1; i < n-1; i++) {
            if (dist[i] > dist[i + 1]) {
                valid = false;
                break;
            }
        }

        System.out.println(valid ? "YES" : "NO");
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : edge[current]) {
                if(dist[next] == -1 || dist[next] > dist[current] + 1){
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}