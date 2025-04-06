
import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y, k;
    static int[] direc;
    static int[][] kan;
    static int[] cube = new int[6];


    //1  2 3  4
    //동 서 북 남
    public static void main(String[] args)  throws IOException{
        input();
        solve();
    }


    //rotate
    private static int[] move(int x, int y, int direction){
        int newx = x; //행을 결정
        int newy = y; //열을 결정
        switch(direction){
            case 1:{//동쪽으로 이동
                if (y + 1 < m){
                    newy +=1;
                    int a = cube[0];
                    int b = cube[1];
                    int c = cube[2];
                    int d = cube[3];
                    int e = cube[4];
                    int f = cube[5];
                    cube  = new int[]{b,c,d,a,e,f};
                    System.out.println(cube[2]);
                }
                return new  int[]{newx, newy};
            }
            case 2:{//서쪽으로 이동
                if (y-1 >= 0){
                    newy -=1;
                    int a = cube[0];
                    int b = cube[1];
                    int c = cube[2];
                    int d = cube[3];
                    int e = cube[4];
                    int f = cube[5];
                    cube = new int[]{d,a,b,c,e,f};
                    System.out.println(cube[2]);
                }
                return new  int[]{newx, newy};
            }
            case 3:{//북쪽으로 이동
                if (x-1 >= 0){
                    newx -= 1;
                    int a = cube[0];
                    int b = cube[1];
                    int c = cube[2];
                    int d = cube[3];
                    int e = cube[4];
                    int f = cube[5];
                    cube = new int[]{f,b,e,d,a,c};
                    System.out.println(cube[2]);
                }
                return new  int[]{newx, newy};
            }
            case 4:{//남쪽으로 이동
                if (x+1 < n){
                    newx +=1;
                    int a = cube[0];
                    int b = cube[1];
                    int c = cube[2];
                    int d = cube[3];
                    int e = cube[4];
                    int f = cube[5];
                    cube = new int[]{e,b,f,d,c,a};
                    System.out.println(cube[2]);
                }
                return new  int[]{newx, newy};
            }
        }
        return null;

    }
    //change
    private static void exchange(int x, int y, boolean didntmove){
        if (!didntmove){

            int kanvalue = kan[x][y];
            if (kanvalue == 0)//칸 값이 0이면 정육면체 cube[cubebottomindex]값을 복사
            {
                kan[x][y] = cube[0];
                cube[0] = 0;
            }else{//칸 값이 0이 아니면, 정육면체 cube[cubebottomindex] 로!! 복사
                cube[0] = kanvalue;
                kan[x][y] = 0;
            }
        }

    }

//solve

    private static void solve(){
        //굴리기 시행 횟수 만큼
        int bottom = 0;

        for(int i = 0 ; i < k; i++ ){

            //정육면체 회전
            boolean didntmove = false;
            int[] newone = move(x,y,direc[i]);
            if ( !(newone[0] == x && newone[1] == y )){
                x = newone[0];
                y = newone[1];
            }else{
                didntmove = true;
            }

            if (newone != null){
                //칸에 숫자와 정육면체 값 교환
                exchange(x,y, didntmove);//정육면체 위치x, 정육면체 위치y, cube[] 칸과 맞닿은 맨 아래 인덱스

            }

        }
    }


    //input
    private static void input() throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //첫째줄
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        //둘째줄
        kan = new int[n][];
        for(int i = 0 ; i < n; i++){
            kan[i] = new int[m];
            kan[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        //셋째줄
        direc = new int[k];
        direc = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();





    }
}