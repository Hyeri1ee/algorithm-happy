


import java.io.*;
import java.util.*;

public class Main {
    static class pair{
        int x; int y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n, m;
    static int[][] arr;
    static int[][] dist;

    static boolean[][] visit;
    static int x, y; //2의 초기 위치

    //좌, 상, 우, 하
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        input();

        Queue<pair> que = new LinkedList<>();
        pair p = new pair(x, y);
        visit[x][y] = true;//방문함 (2)
        dist[x][y] = 0;
        que.add(p);
        boolean found = false;
        while(!found && !que.isEmpty()){
            pair t = que.poll();

            for(int i = 0 ; i < 4; i++){
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    if (arr[nx][ny] == 0 && !visit[nx][ny])//0이고,  방문한 곳이 아닐때
                    {
                        visit[nx][ny] = true;
                        que.add(new pair(nx, ny));
                        dist[nx][ny] = dist[t.x][t.y] + 1;

                    }else if (arr[nx][ny] != 1 && !visit[nx][ny])//3,4,5 이고, 방문한 곳이 아닐때
                    {
                        found = true;
                        dist[nx][ny] = dist[t.x][t.y] + 1;
                        System.out.println("TAK\n" + dist[nx][ny]);
                        break;
                    }
                }
            }
        }

        if (!found)
            System.out.println("NIE");

    }
    private static void input() throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0 ;i < n; i++){
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
                if (arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }


    }
}
