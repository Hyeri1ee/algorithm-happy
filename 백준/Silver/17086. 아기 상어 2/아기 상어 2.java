

import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] arr;
    static int[][] dist;
    static int max = 0;

    static int[] dx = {-1,-1,0,1,1,1,0,-1}; //좌, \ , 상, / 우 , \ , 하 , /
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args)throws Exception{
        input();
        System.out.println(solve());
    }
    private static int solve(){
        Queue<int[] > q = new LinkedList<>();
        dist = new int[n][m];

        //상어가 있는 칸 큐에 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    q.add(new int[]{i, j});
                    dist[i][j] = 0; //상어 칸은 거리0
                }
            }
        }

        int max = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (arr[nx][ny] == 0 && dist[nx][ny] == 0) { //아직 방문 안한 빈 칸
                    dist[nx][ny] = dist[x][y] + 1;
                    max = Math.max(max, dist[nx][ny]);
                    q.add(new int[]{nx, ny});//bfs
                }
            }
        }
        return max;

    }

    private static void find(int x , int y, int dpth){
        if (arr[x][y] == 1)
        {
            max = Math.max(max, dpth);//max값 갱신
            return;
        }
        //1차 탐지
        for(int i = 0 ; i < 8 ; i++){
            if (checkBounds(x, y, i))
                find(x + dx[i], y + dy[i], dpth + 1);
        }
    }

    private static boolean checkBounds(int x, int y, int i){
        boolean xGreat = x + dx[i] >= 0 && x + dx[i] < n;
        boolean yGreat = y + dy[i] >= 0 && y + dy[i] < m;

        return xGreat && yGreat;
    }

    public static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][];
        for(int i = 0 ; i < n; i++)
            arr[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();


    }
}
