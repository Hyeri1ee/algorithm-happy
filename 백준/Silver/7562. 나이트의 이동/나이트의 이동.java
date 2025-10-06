
import java.io.*;
import java.util.*;

public class Main {
    /*
    큐에 다음단계에 갈 수 있는 위치x,y 넣고
    해당 위치가 도착지점인지 판별
    count 매번 라운드마다
     */
    static int t, n;
    static int[][] chess;
    static int sx,sy, ex,ey;

    static class xy{
        int x, y;
        int dist;
        public xy(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.dist = d;
        }
    }
    static int[] dx = {2,1,-1,-2,-2,-1,1,2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());
        while(t-- >0){
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            //
            if (sx == ex && sy == ey) {
                sb.append("0\n");
                continue;
            }

            chess = new int[n][n];
            Queue<xy> list = new LinkedList<>();
            list.add(new xy(sx, sy, 0));
            boolean found = false;

            while(!list.isEmpty() && !found){
                xy pop = list.poll();
                for(int i = 0; i < 8; i++){
                    int nx = pop.x + dx[i];
                    int ny = pop.y + dy[i];
                    if (!isin(nx, ny) || chess[nx][ny] == 1) continue;

                    if (nx == ex && ny == ey){
                        sb.append(pop.dist+1+"\n");
                        found = true;
                        break;
                    }else{
                        chess[nx][ny] = 1;
                        list.add(new xy(nx, ny, pop.dist+1));
                    }
                }
            }
        }

        System.out.println(sb);
    }

    private static  boolean isin(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
