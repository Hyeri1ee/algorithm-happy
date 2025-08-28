

import java.io.*;
import java.util.*;
//시간초과 -> solve()
public class Main {

    static class baekjo{
        int x; int y;
        public baekjo(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    /*
    기존 '처음' originMap을 저장해놓고, originMap을 기준으로 1일당 바뀌는 map을 갱신
    1일당 백조까지 가는 방법이 막혀있는지 확인 -> 너비우선탐색
     */
    static int r,c;
    static char[][] originMap, map;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static baekjo[] bs = new baekjo[2];


    static Queue<baekjo> water = new LinkedList<>();
    static Queue<baekjo> nextWater = new LinkedList<>();
    static Queue<baekjo> swan = new LinkedList<>();
    static Queue<baekjo> nextSwan = new LinkedList<>();
    static boolean[][] swanVisited;


    static int answer = 0;
    public static void main(String[]args) throws Exception{
        input();
        solve2();
        //solve();
    }

    private static void solve2(){
        swanVisited = new boolean[r][c];
        swan.add(bs[0]);
        swanVisited[bs[0].x][bs[0].y] = true;

        while (true) {

            if (swanBFS()) {
                System.out.println(answer);
                return;
            }
            melt();
            answer++;
        }
    }

    private static boolean swanBFS() {
        while(!swan.isEmpty()){
            baekjo cur = swan.poll();
            if (cur.x == bs[1].x && cur.y == bs[1].y)
                return true;

            for(int d = 0 ; d <4;d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];


                //범위를 벗어나는 부분
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (swanVisited[nx][ny]) continue;

                swanVisited[nx][ny] = true;
                if (originMap[nx][ny] == 'X') {
                    nextSwan.add(new baekjo(nx, ny)); //내일갈거
                } else {
                    swan.add(new baekjo(nx, ny)); //오늘 갈거
                }

            }
        }

        swan = nextSwan;
        nextSwan = new LinkedList<>();
        return false;
    }

    private static void melt() {
        int size = water.size(); //오늘 처리할 물의 개수
        while (size-- > 0) {
            baekjo cur = water.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d], ny = cur.y + dy[d];
                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

                if (originMap[nx][ny] == 'X') {
                    originMap[nx][ny] = '.';
                    nextWater.add(new baekjo(nx, ny));
                }
            }
        }

        water.addAll(nextWater);
        nextWater.clear();
    }




    private static void solve(){
        while(! baekjoCanMeet()){//백조가 만날 수 없을때
            answer++;

            for(int i = 0 ; i < r ; i++){
                for(int j = 0; j < c; j++){
                    if (originMap[i][j] == 'X') {//비교는 originMap으로.
                        if (isEdgeX(i, j)) {
                            map[i][j] = '.';//얼음을 녹이기
                        }
                        else {//얼음 녹일 곳이 아닌 경우, X
                            map[i][j] = originMap[i][j];
                        }
                    }
                    else {//얼음 녹일 곳이 아닌 경우, . , L
                        map[i][j] = originMap[i][j];
                    }
                }
            }//end of for

            //originMap으로 map을 복붙
            copyToLeft(originMap, map);
        }
        System.out.println(answer);
    }

    private static boolean baekjoCanMeet(){//두 마리의 백조가 마주할 수 있는지
        boolean[][] visited = new boolean[r][c];
        Queue<baekjo> q = new LinkedList<>();

        q.add(bs[0]);
        visited[bs[0].x][bs[0].y] = true;

        while(!q.isEmpty()){
            baekjo cur = q.poll();

            if (cur.x == bs[1].x && cur.y == bs[1].y)
                return true;

            for(int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                //범위 안 && 아직 방문 안 했고 && 물이라면 이동 가능
                if(nx >=0 && nx <r && ny >= 0 && ny < c) {
                    if (!visited[nx][ny] && (map[nx][ny] == '.' || map[nx][ny] == 'L')) {
                        visited[nx][ny] = true;
                        q.add(new baekjo(nx, ny));
                    }
                }
            }
        }
        return false;
    }

    private static boolean isEdgeX(int x, int y){
        for(int i = 0 ; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && originMap[nx][ny] == '.'){//비교는 originMap은
                return true;
            }

        }
        return false;
    }



    private static void input() throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        originMap = new char[r][];
        map = new char[r][c];

        int count = 0;

        for(int i = 0 ; i < r ; i++){
            originMap[i] = bf.readLine().toCharArray();

            //백조 넣기
            for(int j = 0 ; j <  c; j++){
               if ( originMap[i][j] == 'L')
               {
                   bs[count] = new baekjo(i, j);
                   count++;
               }

                if (originMap[i][j] != 'X') { //물(.)이거나 백조(L)라면
                    water.add(new baekjo(i, j));
                }
            }


        }
        copyToLeft(map, originMap);
    }

    private static void copyToLeft(char[][] map, char[][] originMap){
        for(int i = 0 ; i < r; i++){
            //map[i] = originMap[i];//요게 문제가 돼서 map이 바뀔때 originMap도 바뀜
            for(int j = 0 ; j <c ; j++){
                map[i][j] = originMap[i][j];
            }
        }
    }
}
