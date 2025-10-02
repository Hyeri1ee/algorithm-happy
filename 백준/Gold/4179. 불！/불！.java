
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int r, c;
    static char[][] arr;

    static int sec = 0;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static Queue<Integer[]> jihun_q = new LinkedList<>();
    static Queue<Integer[]> fire_q = new LinkedList<>();

    static int[][] jihun;
    static int[][] fire;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args)throws Exception{
        st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        jihun = new int[r][c];
        fire = new int[r][c];

        for(int i=0; i<r; i++){
            Arrays.fill(jihun[i], -1);
            Arrays.fill(fire[i], -1);
        }

        int startX = -1, startY = -1;
        for(int i = 0 ; i < r; i++){
            arr[i] =bf.readLine().toCharArray();
            for(int j = 0 ; j < c; j++){
                char t = arr[i][j];
                if (t == 'J') {//사람
                    jihun[i][j] = 0;
                    jihun_q.add(new Integer[]{i, j});
                    startX = i;
                    startY = j;
                }else if (t == 'F'){//불
                    fire[i][j] = 0;
                    fire_q.add(new Integer[]{i, j});
                }else if (t == '#'){
                    jihun[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        //시작부터 가장자리에 있으면 바로 탈출
        if (startX == 0 || startX == r-1 || startY == 0 || startY == c-1) {
            System.out.println(1);
            return;
        }

        //=========

        //1 불 도달

        while(!fire_q.isEmpty()){
            Integer[] s = fire_q.poll();
            int x = s[0];
            int y = s[1];
            for(int i = 0 ; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (isin (nx, ny) && arr[nx][ny] != '#' && fire[nx][ny] == -1)
                {
                    fire[nx][ny] = fire[x][y] + 1;
                    fire_q.add(new Integer[]{nx, ny});
                }

            }
        }

        //2 지훈

        while(! jihun_q.isEmpty()) {
            Integer[] s = jihun_q.poll();
            int x = s[0];
            int y = s[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (!isin(nx, ny)) {

                    System.out.println(jihun[x][y] + 1);
                    return;

                }

                int expectedTime = jihun[x][y] + 1;
                if (arr[nx][ny] != '#' && jihun[nx][ny] == -1 &&
                        (fire[nx][ny] == -1 || expectedTime < fire[nx][ny])) {
                    jihun[nx][ny] = expectedTime;
                    jihun_q.add(new Integer[]{nx, ny});
                }


            }
        }
        System.out.println("IMPOSSIBLE");



    }

    private static boolean isin(int x, int y){
        return x>=0 && x <r && y >=0 && y<c;
    }


}
