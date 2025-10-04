
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int no = 0;
    static int yes = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0 ; i  < n ;i ++){
            Arrays.fill(visited[i], false);
            arr[i] = bf.readLine().toCharArray();
        }

        //no
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if (!visited[i][j]) {
                    bfs1(arr[i][j], i, j);
                    no++;
                }
            }
        }

        for(int i = 0 ; i  < n ;i ++){
            Arrays.fill(visited[i], false);
            //arr[i] = bf.readLine().toCharArray();
        }

        //yes
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if (!visited[i][j]) {
                    bfs2(arr[i][j], i, j);
                    yes++;
                }
            }
        }

        System.out.print(no + " " + yes);




    }

    private static void bfs2(int c, int i, int j){
        if (!visited[i][j]){
            visited[i][j] = true;

            for(int p = 0 ; p < 4; p++){
                int nx = i + dx[p];
                int ny = j + dy[p];
                if (! isin(nx, ny)) continue;

                switch (c){
                    case 'R':{
                        if (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')
                            bfs2(c, nx, ny);

                        break;
                    }
                    case 'G':{
                        if (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')
                            bfs2(c, nx, ny);

                        break;
                    }
                    case 'B':{
                        if (arr[nx][ny] == c)
                            bfs2(c, nx, ny);

                        break;
                    }
                }

            }
        }
    }

    private static void bfs1(int c, int i, int j){
        if (!visited[i][j]){
            visited[i][j] = true;

            for(int p = 0 ; p < 4; p++){
                int nx = i + dx[p];
                int ny = j + dy[p];
                if (! isin(nx, ny)) continue;

                if (arr[nx][ny] == c){
                    bfs1(c, nx, ny);
                }
            }
        }
    }

    private static boolean isin(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
