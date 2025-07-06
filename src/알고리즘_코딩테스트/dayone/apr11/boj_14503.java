package 알고리즘_코딩테스트.dayone.apr11;

import java.io.*;
import java.util.*;

//구현 순서대로 적기
//input()은 완료
//구현 완료
//테스트 (예제입력 1 통과, 예제입력 2

/*
   0 1 2 3 4 5 6 7 8 9
0  1 1 1 1 1 1 1 1 1 1
1  1 0 0 0 0 0 0 0 0 1
2  1 0 0 0 1 1 1 1 0 1
3  1 0 0 1 1 0 0 0 0 1
4  1 0 1 1 0 0 0 0 0 1
5  1 0 0 0 0 0 0 0 0 1
6  1 0 0 0 0 0 0 1 0 1
7  1 0 0 0 1 0 1 1 0 1
8  1 0 0 0 0 0 1 1 0 1
9  1 0 0 0 0 0 0 0 0 1
10 1 1 1 1 1 1 1 1 1 1
 */


public class boj_14503 {
    static int n, m; // 칸의 개수
    static int[][] kan;
    static int x, y, d; // 로봇 청소기 현재 위치, 방향
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        input();
        solve(); // 로봇 청소기 동작

        System.out.println(answer);
    }

    private static void solve() {
        // 1. 현재 칸이 청소되지 않았다면 청소
        if (kan[x][y] == 0) {
            kan[x][y] = 2; // 청소됨
            answer++;
        }

        // 2. 로봇 청소기가 벽에 부딪히지 않는 한 계속 반복
        while (true) {
            // 3. 주변 4칸 중 청소되지 않은 칸이 있으면 반시계 방향으로 회전 후 전진
            if (notCleanExist()) {
                for (int i = 0; i < 4; i++) {
                    rotateLeft(); // 반시계 방향으로 회전
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // 청소되지 않은 빈칸이 있으면 전진
                    if (inrange(nx, ny) && kan[nx][ny] == 0) {
                        x = nx;
                        y = ny;
                        kan[x][y] = 2; // 청소
                        answer++;
                        break;
                    }
                }
            } else {
                // 4. 주변에 청소되지 않은 칸이 없다면 후진
                int backDir = (d + 2) % 4; // 반대 방향으로 후진
                int bx = x + dx[backDir];
                int by = y + dy[backDir];

                // 후진할 수 있으면 후진
                if (inrange(bx, by) && kan[bx][by] != 1) {
                    x = bx;
                    y = by;
                } else {
                    break; // 후진할 수 없으면 종료 -> while
                }
            }
        }
    }

    // 반시계 방향으로 90도 회전
    private static void rotateLeft() {
        d = (d + 3) % 4; // d: 0 - 북, 1 - 동, 2 - 남, 3 - 서
    }

    // 주변에 청소되지 않은 빈 칸이 존재하는지 확인
    private static boolean notCleanExist() {
        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];

            // 범위 내에 있고 청소되지 않은 칸이 존재하면 true
            if (inrange(newx, newy) && kan[newx][newy] == 0) {
                return true;
            }
        }
        return false;
    }

    // 범위 내에 위치한 경우만 true
    private static boolean inrange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    // 입력 받기
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        kan = new int[n][m];
        for (int i = 0; i < n; i++) {
            kan[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}

/*
public class boj_14503 {
    static int n,m; //칸의 개수
    static int[][] kan;
    static int x,y,d; //로봇 청소기 현재 위치 , 방향
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int answer = 0;

    public static void main(String[] args)throws IOException{
        input();
        solve();//현재 로봇 청소기 위치

        System.out.println(answer);
    }

    private static void solve(){
        //kan의 각 값에 대해서 0 : 청소 안됨, 1 : 벽이 있음, 2: 청소됨
        //d 값에 대해서 0 : 북쪽, 1: 동쪽, 2: 남쪽, 3:서쪽
        if (kan[x][y] == 0){
            kan[x][y] = 2;//청소
            answer++;
        }
        while(behindIsNotWall()){//(청소할 칸이 주변에 존재할 경우) 이게 아님,,, 바라보는 방향의 뒤쪽칸이 벽이 아니라 후진 가능

            if (kan[x][y] == 0){
                kan[x][y] = 2;//청소
                answer++;
            }

            if (notCleanExist()){//주변 4칸 중 청소되지 않은 칸 존재
                while(notCleanedExistInfront()){//벽이거나 청소된 상태인 경우 true 반환
                    d = changeDirection();//90도 반시계 회전 + 앞에 청소 안된 칸이 있을 때까지
                }
                go(1);//청소되지 않은 칸으로 전진한다 // 1은 전진
                if (kan[x][y] == 0){
                    kan[x][y] = 2;//청소
                    answer++;
                }


            }else{//주변 4칸 중 청소되지 않은 칸 존재 하지 않음
                //후진할 수 있다면
                if (cangoBack()){
                    go(-1);//-1은 후진
                    if (kan[x][y] == 0){
                        kan[x][y] = 2;//청소
                        answer++;
                    }

                }else{//멈춤
                    break;
                }

            }

        }




        //1. 현재칸이 청소되었는지 확인후 청소
        //2. 현재 칸의 주변 4칸 중 *청소되지 않은 빈 칸이 없는지 확인 .
        //2.1 주변에 빈칸이 없으면 *방향 유지한 채로 *한칸 후진
        //2.2 주변에 빈칸이 있으면 *반시계 90도 회전
    }

    private static boolean behindIsNotWall(){
        int newx = x;
        int newy = y;
        //d에 따라 뒤의 정의가 바뀜
        switch (d){
            case 0:{//북쪽
                newx += 1;//남쪽이 뒤
                break;
            }
            case 1:{//동쪽
                newy -= 1;//서쪽이 뒤
                break;
            }
            case 2:{//남쪽
                newx -= 1;//북쪽이 뒤
                break;
            }
            case 3:{//서쪽
                newy += 1;//동쪽이 뒤
                break;
            }
        }
        //newx, newy는 inrange값들인지 확인
        if(inrange(newx, newy)){//범위 내고, 뒤쪽이 벽(1)이 아니면 behindIsNotWall = true
            if(kan[newx][newy] != 1)
                return true;
        }
        //범위 밖 경계선이 벽임 따라서 behindIsNotWall = false
        return false;
    }

    private static boolean cangoBack(){
        int newx = x;
        int newy = y;
        //d에 따라 앞의 정의가 바뀜
        switch (d){
            case 0:{//북쪽
                newx += 1;//남쪽으로 감
                break;
            }
            case 1:{//동쪽
                newy -= 1;//서쪽으로 감
                break;
            }
            case 2:{//남쪽
                newx -= 1;//북쪽으로 감
                break;
            }
            case 3:{//서쪽
                newy += 1;//동쪽으로 감
                break;
            }
        }
        //newx, newy는 inrange값들인지, 후진하는 위치가 벽이 아닌지 확인
        if(inrange(newx, newy) && kan[newx][newy] != 1){
            return true;
        }else
            return false;

    }
    private static void go(int i){//i가 1이면 전진, i가 -1이면 후진
        int newx = x;
        int newy = y;
        //d에 따라 앞의 정의가 바뀜
        switch (d){
            case 0:{//북쪽
                newx -= 1 * i;
                break;
            }
            case 1:{//동쪽
                newy += 1 * i;
                break;
            }
            case 2:{//남쪽
                newx += 1 * i;
                break;
            }
            case 3:{//서쪽
                newy -= 1 * i;
                break;
            }
        }
        //newx, newy는 inrange값들일 수 밖에 없음
        x = newx;
        y = newy;

    }
    private static boolean notCleanedExistInfront(){
        int newx = x;
        int newy = y;
        //d에 따라 앞의 정의가 바뀜
        switch (d){
            case 0:{//북쪽
                newx -= 1;
                break;
            }
            case 1:{//동쪽
                newy += 1;
                break;
            }
            case 2:{//남쪽
                newx += 1;
                break;
            }
            case 3:{//서쪽
                newy -= 1;
                break;
            }
        }
        //범위 내에 있는 경우, 앞에 청소되지 않은 칸이 있는 경우
        if (inrange(newx, newy) && kan[newx][newy] == 0)
            return false;
        else{
            return true;
        }


    }

    private static int changeDirection(){
        return  ((d-1) + 4 ) % 4;

    }

    private static boolean notCleanExist(){
        boolean check = false;

        for(int i = 0 ; i < 4; i++){
            int newx = x + dx[i];
            int newy = y + dy[i];

            if (inrange(newx, newy)){//범위 안에 있음
                if (kan[newx][newy] == 0)//청소되지 않은 빈칸이 적어도 한 개 존재하면 check = true로 반환
                {
                    check  = true;
                    return check;
                }
            }

        }

        return check;

    }

    private static boolean inrange(int x, int y){//로봇의 새로운 위치가 칸 내부에 있는 여부 확인
        if( x >= 0 && x < m && y >= 0 && y < n)
            return true;
        else
            return false;
    }

    private static void input()throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        d = Integer.parseInt(st.nextToken());

        kan = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            kan[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
*/
