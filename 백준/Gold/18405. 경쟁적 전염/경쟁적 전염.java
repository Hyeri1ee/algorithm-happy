

import java.io.*;
import java.util.*;

public class Main {
    static class virus implements Comparable<virus> {
        int x, y, val;
        public virus(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(virus o1) {//val을 기준으로 오름차순 정렬
            return this.val - o1.val;
        }
    }

    static int n, k;
    static int[][] arr;
    static int s, x, y;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0 , 1, 0, -1};

    static PriorityQueue<virus> viruses = new PriorityQueue<>();

    public static void main(String[] args) throws Exception
    {
        input();
        solve();

        //결과
        System.out.println(arr[x-1][y-1]);
    }

    private static void solve(){
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ;j < n;j++){
                if (arr[i][j] != 0)
                    viruses.add(new virus(i, j, arr[i][j]));
            }
        }//end of for

        //viruses는 자동 오름차순 정렬됨
        int time = 0;
        while(time < s){
            int size = viruses.size(); //현재 큐에 있는 것들만 처리
            List<virus> next = new ArrayList<>();

            for(int cnt = 0; cnt < size; cnt++){
                virus v = viruses.poll();

                for(int i = 0; i < 4; i++){
                    int nx = v.x + dx[i];
                    int ny = v.y + dy[i];

                    if (exist(nx, ny) && arr[nx][ny] == 0){
                        arr[nx][ny] = v.val;
                        next.add(new virus(nx, ny, v.val));
                    }
                }
            }

            viruses.addAll(next);//한꺼번에 넣어주기!!!
            time++;
        }

    }

    private static boolean exist(int x, int y){
        return x >= 0 && x < n  && y >= 0 && y < n;
    }

    private static void input() throws Exception{
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }

        st = new StringTokenizer(bf.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

    }
}
