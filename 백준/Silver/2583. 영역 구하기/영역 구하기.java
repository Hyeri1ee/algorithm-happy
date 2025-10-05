
import java.io.*;
import java.util.*;

public class Main {
    static int m, n, k;
    static int[][] arr;
    static boolean[][] visit;

    static class xy{
        int x , y;
        public xy(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    /*
    static class rec{
        xy p1,p2;
        public rec(xy a1, xy a2){
            this.p1= a1;
            this.p2=a2;
        }
    }

     */
   // static rec[] recList;
    static int count = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] ar) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        visit = new boolean[m][n];
        for(int i =0 ; i< m;i++){
            Arrays.fill(visit[i] ,false);
        }
        //recList = new rec[k];
        for(int i =0; i< k; i++){
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
           // xy xy1 = new xy(x1, y1);
           // xy xy2 = new xy(x2, y2);
           // recList[i] = new rec(xy1, xy2);

            //arr에 반영
            for(int y = y1; y < y2;y++){
                for(int x = x1; x < x2; x++){
                    arr[y][x] = 1;
                }
            }
        }

        Queue<xy> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0 ; i < m; i++){
            for(int j =0;j<n;j++){
                int num = 0;
                if (!visit[i][j] && arr[i][j] == 0){
                    num++;
                    queue.add(new xy(i, j));
                    visit[i][j] = true;

                    while(!queue.isEmpty()){
                        xy pop= queue.poll();
                        int x = pop.x;
                        int y = pop.y;


                        for(int a = 0; a< 4; a++){
                            int nx = x + dx[a];
                            int ny = y + dy[a];
                            if (isin(nx, ny) && !visit[nx][ny] && arr[nx][ny] == 0)
                            {
                                num++;
                                visit[nx][ny] = true;
                                queue.add(new xy(nx, ny));
                            }
                        }
                    }
                }
                if (num !=0)
                    list.add(num);



            }
        }

        //(위) queue에 0 인 값들의 위치 넣기
        Collections.sort(list);
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i)+ " ");
        }
        System.out.println(sb);



    }

    private static boolean isin(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
