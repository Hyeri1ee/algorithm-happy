package 알고리즘_코딩테스트.dayone.mar01;

import java.io.*;
import java.util.*;

class Pair{
    int x; int y; int distance;
    public Pair(int x, int y, int distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
}
public class BOJ_2178 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] miro;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0,-1,1,0};
    static Queue<Pair> pairsList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // n, m 입력 받기

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][];
        visited = new boolean[n][];
        // int[][] 입력 받기

        for (int i = 0 ; i  < n ; i++){
            String input = bf.readLine();
            visited[i] = new boolean[m];
            Arrays.fill(visited[i], false);

            miro[i] = Arrays.stream(input.split("")).mapToInt(Integer::parseInt).toArray();
        }

        // 너비 우선 탐색
        int result = bfs(new Pair(0, 0, 1));
        System.out.println(result);

    }

    private static int bfs(Pair pair){
        pairsList.add(pair);
        visited[pair.x][pair.y] = true;


        while(!pairsList.isEmpty()){
            Pair pop = pairsList.poll();

            if (pop.x == n-1 && pop.y == m-1){
                return pop.distance;
            }

            for (int i = 0 ; i < 4 ; i++) {
                int nx = pop.x + dx[i];
                int ny = pop.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (miro[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        pairsList.add(new Pair(nx, ny, pop.distance + 1));
                    }
                }
            }

        }
        return -1; //도달 안함

    }
}
