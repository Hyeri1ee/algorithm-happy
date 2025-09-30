
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int max = 0;
    static int num  = 0;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n; i++){

            arr[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }


        //===========
        for(int x = 0; x < n ; x++){
            for(int y = 0 ; y < m; y++){
                if (arr[x][y] == 0 || visited[x][y]) continue;

                Queue<int[]> queue = new LinkedList<>();
                visited[x][y] = true;
                queue.add(new int[]{x,y});
                int sum = 1 ;

                while(!queue.isEmpty()){
                    int[] t = queue.poll();

                    for(int i =0 ; i < 4; i++){
                        int nx = t[0] + dx[i];
                        int ny = t[1] + dy[i];
                        if (isin(nx, ny) && arr[nx][ny] == 1 && !visited[nx][ny]){
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            sum++;
                        }
                    }
                }
                num++;
                max = Math.max(sum, max);
            }
        }

        System.out.println(num);
        System.out.println(max);



    }



    private static boolean isin(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }
}
