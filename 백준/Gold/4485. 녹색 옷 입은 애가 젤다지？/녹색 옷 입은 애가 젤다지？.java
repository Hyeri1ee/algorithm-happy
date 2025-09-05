
import java.io.*;
import java.util.*;

public class Main {

        static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));;
        static StringTokenizer st;
        static int n = -1;
        static int[][] arr;
        static int[][] shortsum;

        static int[] dx = {-1,0,1,0};
        static int[] dy = {0,1,0,-1};
        static int count = 0 ;
        static StringBuilder sb = new StringBuilder();

        public static void main(String[] args) throws Exception{
            while (true) {
                input();
                if (n == 0) break;
                solve();
            }
            System.out.println(sb);

        }

        private static void solve(){
            //중복 탐색 줄임
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            for(int[] row : shortsum)
                Arrays.fill(row, Integer.MAX_VALUE);

            shortsum[0][0] = arr[0][0];
            pq.offer(new int[]{arr[0][0], 0, 0});//비용, x, y

            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                int cost = cur[0], x = cur[1], y = cur[2];

                if (x == n-1 && y == n-1)
                    break;
                if (cost > shortsum[x][y])
                    continue;

                for(int d = 0 ; d < 4; d++){
                    int nx = x + dx[d], ny = y + dy[d];

                    if (nx <0 || ny < 0 || nx >= n || ny >= n) continue;
                    int newCost = cost + arr[nx][ny];
                    if (newCost < shortsum[nx][ny])
                    {
                        shortsum[nx][ny] = newCost;
                        pq.offer(new int[]{newCost, nx, ny});
                    }
                }
            }

            count++;
            sb.append("Problem " + count + ": " + shortsum[n-1][n-1] + "\n");

        }

        /*
        //결과출력용
        static StringBuilder sb =new StringBuilder();
        static int count;

        public static void main(String[] args) throws Exception{
            while(true){
                input();
                solve();

                if (n == 0 )//n == 0일때 input, solve에서 return함
                    break;
            }

            System.out.println(sb);
        }

        private static void solve(){

            if (n == 0) return;


            //x - 1 , y + 1
            int x = -2;  int y = 1; int forNUm = 0; boolean up = true;

            for(int i = 0; i < 2 * n - 1 ; i++ ){

                x += 1;
                y -= 1;

                //x,y,forNum 갱신
                if (i >= n - 1)
                    x = n-1;
                else
                    x++;

                if ( i <= n - 1)
                    y = 0;
                else
                    y++;

                //증감 바뀜
                boolean check = true;
                if (forNUm == n)
                {
                    up = false;
                }

                if (forNUm == n && check)
                {
                    check = false; //forNum == n인 경우 한번만 여기에 걸리도록
                    continue;
                }
                else if (up)
                    forNUm++;
                else
                {
                    forNUm--;
                }

                for(int j = 0; j < forNUm; j++){
                    //arr[x][y]에서의 까지의 최소 계산
                    if (exist(x, y))
                        shortsum[x][y] = select(x,y-1, x-1, y) + arr[x][y];
                    //x, y 오른쪽 대각선 방향으로 갱신
                    x -= 1;
                    y += 1;
                }
            }


            //결과출력
            count++;
            sb.append("Problem "+ count +": " + shortsum[n-1][n-1]+"\n");

        }

        private static boolean exist(int x, int y){
            return x >= 0 && x < n  && y >= 0 && y < n;
        }

        private static int select(int a1, int b1, int a2, int b2){
            //a1, b1, a2,b2의 값 유효한지 판별
            boolean one_good = a1 >= 0 && a1 < n && b1 >= 0 && b1 < n;
            boolean two_good = a2 >= 0 && a2 < n && b2 >= 0 && b2 < n;

            if (one_good && two_good)//일반적인 케이스
                return Math.min(shortsum[a1][b1] , shortsum[a2][b2]);
            else if (one_good)//맨위
                return shortsum[a1][b1];
            else if (two_good)//맨왼쪽
                return shortsum[a2][b2];
            else
                return arr[0][0];//맨왼쪽 위
        }

         */

        private static void input() throws Exception{
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0 ) return;

            //초기화
            arr = new int[n][n];
            shortsum= new int[n][n];

            for(int i = 0 ;i<n; i++){
                arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            }

        }
}
