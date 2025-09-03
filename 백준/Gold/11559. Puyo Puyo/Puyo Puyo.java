
import java.io.*;
import java.util.*;

/*
https://www.acmicpc.net/problem/11559
 */
public class Main {
    static int n = 12;
    static int m = 6;
    static char[][] field = new char[n][m];
    static boolean[][] visit = new boolean[n][m];
    static int count = 0;//연쇄 횟수 //// 터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터지고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws  Exception{
        input();
        solve();
    }
    private static void solve(){

        while(true){
            boolean exploded = false;
            for(int i = 0 ; i < n ; i++){
                Arrays.fill(visit[i], false);
            }

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if (field[i][j] == '.' || visit[i][j]) continue;


                    Queue<int[]> que = new LinkedList<>();
                    Queue<int[]> save = new LinkedList<>();

                    que.add(new int[]{i, j});
                    save.add(new int[]{i, j});
                    visit[i][j] = true;

                    while(!que.isEmpty()){
                        int[] t = que.poll();

                        for(int p = 0 ; p < 4 ; p++){
                            int nx = t[0] + dx[p];
                            int ny = t[1] + dy[p];

                            if (exist(nx, ny) && !visit[nx][ny] && field[i][j] == field[nx][ny]){//연이은 R,Y,G
                                que.add(new int[]{nx, ny});
                                save.add(new int[]{nx, ny});
                                visit[nx][ny] = true;
                            }
                        }
                    }//end of while

                    if (save.size() >= 4){
                        exploded = true;
                        while(! save.isEmpty()){
                            int[] t = save.poll();
                            field[t[0]][t[1]] = '.';
                        }
                    }

                }
            }

            if (!exploded) break;//더이상 터질게 없음
            count++;
            applygravity();//중력
        }


        System.out.println(count);


        /*for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                if (field[i][j] == '.') continue;

                Queue<int[]> que = new LinkedList<>();
                Queue<int[]> save = new LinkedList<>();

                que.add(new int[]{i, j});
                save.add(new int[]{i, j});
                visit[i][j] = true;

                while(!que.isEmpty()){
                    int[] t = que.poll();

                    for(int p = 0 ; p < 4 ; p++){
                        int nx = t[0] + dx[p];
                        int ny = t[1] + dy[p];

                        if (exist(nx, ny) && field[i][j] == field[nx][ny]){//연이은 R,Y,G
                            que.add(new int[]{nx, ny});
                            save.add(new int[]{nx, ny});
                        }
                    }
                }//end of while

                if (save.size() >= 4){
                    while(! save.isEmpty()){
                        int[] t = save.poll();

                        field[t[0]][t[1]] = '.';
                    }
                }

                //중력!!
                for(int a = m-1; a > 0; a--){

                }

            }
        }*/
    }
    private static void applygravity(){
        for(int col = 0 ; col < m ; col++){
            int emrow = n-1;
            for(int row = n-1; row>= 0 ;row--){
                if (field[row][col] != '.'){//.가 아님
                    char temp = field[row][col];
                    field[row][col] = '.';
                    field[emrow][col] = temp;
                    emrow--;
                }
            }
        }
    }

    private static boolean exist(int x, int y){
        return x >= 0 && y >= 0 &&x < n && y < m;
    }

    private static void input()throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(visit[i], false);
        }

        for(int i = 0 ; i <n; i++){

            field[i] = bf.readLine().toCharArray();
        }


    }
}
