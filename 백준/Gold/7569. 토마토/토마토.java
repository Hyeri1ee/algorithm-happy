
import java.io.*;
import java.util.*;

public class Main {
    static  class pos{
        int x, y, z;
        public pos(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static int m, n, h;
    static int[][][] arr;
    static boolean[][][] visit;

    static int[] dh = {0,0,0,0,-1,1};
    static int[] dn = {1,-1,0,0,0,0};
    static int[] dm = {0,0,1,-1,0,0};
    static int count= 0;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];
        visit = new boolean[h][n][m];
        for(int i = 0 ; i <  h; i++){

            for(int j = 0 ; j < n; j++){
                Arrays.fill(visit[i][j] , false);
                arr[i][j] = Arrays.stream(bf.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

            }
        }

        //=======
        Queue<pos> queue = new LinkedList<>();
        for(int i = 0 ; i < h  ; i ++){
            for(int j = 0; j<n; j++){
                for(int k = 0 ; k < m; k++){
                    if (arr[i][j][k] == 1){
                        queue.add(new pos(i, j, k));
                        visit[i][j][k] = true;
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            pos pop = queue.poll();
            for(int a = 0; a< 6; a++){
                int nh = pop.x + dh[a];
                int nn = pop.y + dn[a];
                int nm = pop.z + dm[a];

                if (! isin(nh, nn, nm)) continue;
                if (visit[nh][nn][nm]) continue;
                if (arr[nh][nn][nm] !=0 ) continue;//익지 않은 토마토가 아니면


                visit[nh][nn][nm] = true;
                arr[nh][nn][nm] = arr[pop.x][pop.y][pop.z] + 1;
                queue.add(new pos(nh, nn, nm));

            }
        }
/*
        for(int i = 0 ; i < h ; i++){
            for(int j = 0 ; j < n ; j++){
                for(int k = 0; k < m; k++){
                    if (!visit[i][j][k] && arr[i][j][k] == 1){
                        count++;
                        queue.add(new pos(i, j, k));
                        while(!queue.isEmpty()){
                            pos pop = queue.poll();
                            for(int a = 0 ; a < 6; a++){
                                int nh =  pop.x + dh[a];
                                int nn =  pop.y + dn[a];
                                int nm =  pop.z + dm[a];

                                if (! isin(nh , nn, nm)) continue;

                                if (!visit[nh][nn][nm] && arr[nh][nn][nm] != -1){
                                    visit[nh][nn][nm] = true;
                                    queue.add(new pos(nh, nn, nm));
                                    arr[nh][nn][nm] = 1;
                                }

                            }
                        }
                    }
                }
            }
        }

 */

        //체크
        int max = 0;
        for(int i =0; i< h;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, arr[i][j][k]);
                }
            }
        }
        System.out.println(max - 1);

    }


    private static boolean isin(int x, int y, int z){
        return x >= 0 && x < h && y >=0 && y < n && z >= 0 && z < m;
    }

}
