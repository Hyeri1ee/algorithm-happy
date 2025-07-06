package 알고리즘_코딩테스트.dayone.apr16;

import java.io.*;
import java.util.*;

public class boj4963 {
    static int w, h;
    static int[][] arr;
    static boolean [][] visited;
    static int[][] union;

    static StringBuilder answer = new StringBuilder();

    static int[] dx = {-1,0,1,-1,1,-1,0,1};
    static int[] dy = {-1,-1,-1,0,0,1,1,1};

    public static void main(String[] args) throws Exception{

        while(true){
            int num = 0;
            input();

            if (w==0 && h==0)
                return;

            //bfs
            for(int i = 0; i < h ; i++){
                for(int j = 0 ; j < w ; j++){
                    if (!visited[i][j])
                        bfs(i, j);
                }
            }

            //answer업데이트
            for(int i = 0 ; i < h ; i++){
                for(int j = 0 ; j < w; j++){
                    if (visited[i][j] && union[i][j] == (i+1) * (j+1))
                        num++;
                }
            }
            answer.append(num + "\n");
        }
    }

    private static void bfs(int x, int y){

        for(int k = 0 ; k < 8; k++){
            int newx = x + dx[k];
            int newy = y + dy[k];
            if (inRange(newx, newy))
                if (arr[newx][newy] == 1){//땅임
                    visited[newx][newy] = true;
                    union[newx][newy] = (x+1) * (y+1);
                }
        }
    }

    private static boolean inRange(int x, int y){
        return (x>= 0 && y >= 0 && x <h && y <w);
    }

    private static void input()throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        if (w == 0 && h == 0)
            return;

        arr = new int[h][];
        visited = new boolean[h][];
        union = new int[h][];

        for(int i = 0 ; i < h ; i++){
            arr[i] = new int[w];
            visited[i] = new boolean[w];
            union[i] = new int[w];

            for(int j = 0 ; j < w; j++){
                union[i][j] = (i+1) * (j+1);
            }
        }

        for(int i = 0 ; i < h; i++){
            Arrays.fill(visited[i], false);
        }

    }
}
