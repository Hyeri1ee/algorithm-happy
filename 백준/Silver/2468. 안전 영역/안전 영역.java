import java.io.*;
import java.util.*;

public class Main {
    /*
    2차원 배열에서 min, max 구한후,
    숫자 하나씩 + 1 하며 물x땅 개수 세기
        잠긴거는 . 으로
        잠기지 않았지만, 이미 방문해서 '안전 영역' 카운팅에 포함된거는 0으로
        visited으로 방문체크해야함
     */
    static int n;
    static int[][] arr;
    static char[][] k;
    static boolean[][] visited;
    static int ans = 0;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        input();

        for(int i = 0; i <= 100; i++){//i이하는 다 회색
            int count = 0;
            visited = new boolean[n][n];


            for(int a = 0 ; a < n; a++){
                Arrays.fill(k[a], '0');
                for(int b = 0 ; b < n; b++){
                    if (arr[a][b] <= i)
                        k[a][b] = '.';
                }
            }
            //잠긴거는 .로 표현함

            for(int j = 0 ; j < n; j++){
                for(int p = 0; p < n ; p++){
                    if (! visited[j][p] && k[j][p] != '.')//잠긴 곳이 아니고, 아직 방문하지 않은 곳이라면
                    {
                        count++;
                        bfs(j, p);
                    }
                }
            }


            //갱신
            if (ans  < count)
                ans = count;

        }
        System.out.println(ans);
    }

    private static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (exist(nx, ny) && !visited[nx][ny] && k[nx][ny] != '.') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean exist(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        visited = new boolean[n][n];
        k = new char[n][n];


        for(int i = 0 ; i < n ; i++){
            arr[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
