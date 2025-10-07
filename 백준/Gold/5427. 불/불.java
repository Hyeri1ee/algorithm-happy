
import java.io.*;
import java.util.*;

public class Main {
    static int t, w, h;
    static char[][] arr;
    static int[][] fire, sangun;

    static int[] dh = {-1,0,1,0};
    static int[] dw = {0,1,0,-1};

    static boolean[][] visited;
    static int starth, startw;
    static class xyd{
        int h, w,  d;
        public xyd(int h, int w, int d){
            this.h =h;
            this.w=w;
            this.d=d;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());
        while(t-->0){
            st=new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new char[h][w];
            fire = new int[h][w];
            sangun = new int[h][w];
            visited = new boolean[h][w];

            for(int i =0 ; i < h ;i++){
                arr[i] = bf.readLine().toCharArray();
                Arrays.fill(fire[i], -1);
                Arrays.fill(sangun[i], -1);
            }

            //fire
            Queue<xyd> list = new LinkedList<>();
            for(int i = 0; i < h; i++){
                for(int j = 0 ;j < w; j++){
                    if (arr[i][j] == '*')
                    {
                        list.add(new xyd(i, j, 0));
                        fire[i][j] = 0;
                    }

                }
            }

            while(!list.isEmpty()){
                xyd pop = list.poll();
                for(int i = 0 ; i < 4 ; i++){
                    int nh = pop.h + dh[i];
                    int nw = pop.w + dw[i];


                    if (!isin(nh, nw) ) continue;
                    if (arr[nh][nw] == '#' || fire[nh][nw] != -1) continue; // 이미 불이 번진 곳 or 벽

                    fire[nh][nw] = fire[pop.h][pop.w] + 1;
                    list.add(new xyd(nh, nw, pop.d + 1));


                }

            }

            //snagun

            Queue<xyd> slist = new LinkedList<>();
            for(int i = 0; i < h; i++){
                for(int j = 0 ;j < w; j++){
                    if (arr[i][j] == '@')
                    {
                        slist.add(new xyd(i, j, 0));
                        sangun[i][j] = 0;

                        starth = i;
                        startw = j;
                    }
                }
            }

            //가능한 시간 확인
            boolean escaped = false;
            int ans = -1;
            while(!slist.isEmpty()){
                xyd cur = slist.poll();
                if (cur.h == 0 || cur.h == h - 1 || cur.w == 0 || cur.w == w - 1) {
                    escaped = true;
                    ans = cur.d + 1;
                    break;
                }

                for(int i =0 ; i< 4; i++){
                    int nh = cur.h + dh[i];
                    int nw = cur.w + dw[i];
                    if (!isin(nh, nw)) continue;
                    if (arr[nh][nw] == '#' || sangun[nh][nw] != -1) continue;
                    if (fire[nh][nw] != -1 && fire[nh][nw] <= cur.d + 1) continue;

                    sangun[nh][nw] = cur.d + 1;
                    slist.add(new xyd(nh, nw, cur.d + 1));
                }
            }

            if (escaped) sb.append(ans).append("\n");
            else sb.append("IMPOSSIBLE\n");




        }
        System.out.print(sb);
    }

    private static boolean isin(int hh, int ww){
        return hh>= 0 && hh < h && ww >= 0 && ww < w;
    }
}
