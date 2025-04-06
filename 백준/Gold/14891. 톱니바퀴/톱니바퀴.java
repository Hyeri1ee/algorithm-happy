


/*
10101111
01111101
11001110
00000010
2
3 -1
1 1


 */
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] wheels;
    static int K;
    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    public static void input() throws IOException {
        wheels = new int[4][8]; // 톱니바퀴 상태 입력
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = s.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
    }

    public static void process() throws IOException {
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;   //회전할 톱니 번호
            int d = Integer.parseInt(st.nextToken());       //회전 방향 ( 1 => 시계, -1 => 반시계)
            int isTurn[] = new int[4]; // 회전 여부 저장
            isTurn[n] = d;

            //톱니바퀴 좌측 비교
            for (int j = 0; n != 0 && j < n; j++) {
                //주어진 톱니바퀴와 방향을 기준으로 톱니바퀴 좌측 비교
                if (wheels[n - j][6] != wheels[n - j - 1][2])
                    //j가 짝수면 다른 방향, 홀수면 같은 방향
                    isTurn[n - j - 1] = j % 2 == 0 ? -d : d;
                else
                    // 같은 극이면 움직이지 않움
                    break;
            }

            //톱니바퀴 우측 비교
            for (int j = 0; n != 3 && j < 4 - n - 1; j++) {
                // 주어진 톱니바퀴와 방향을 기준으로 톱니바퀴 우측 비교
                if (wheels[n + j][2] != wheels[n + j + 1][6])
                    //j가 짝수면 다른 방향, 홀수면 같은 방향
                    isTurn[n + j + 1] = j % 2 == 0 ? -d : d;
                else
                    // 같은 극이면 움직이지 않움
                    break;
            }

            // 톱니바퀴 회전
            for (int j = 0; j < 4; j++) {
                // 시계방향 회전
                if(isTurn[j] == 1)
                    goTurn(j);
                    // 반시계방향 회전
                else if(isTurn[j] == -1)
                    goBack(j);
            }
        }

        int result = 0;	// 점수
        for (int i = 0; i < 4; i++) {
            if(wheels[i][0] == 1)
                result += Math.pow(2, i);	// i번째 톱니바퀴 점수 : 2^i
        }

        System.out.println(result);
    }

    // 반시계방향
    private static void goBack(int n) {
        int temp = wheels[n][0];
        for (int i = 0; i <= 6; i++)
            wheels[n][i] = wheels[n][i + 1];
        wheels[n][7] = temp;
    }

    // 시계방향
    private static void goTurn(int n) {
        int temp = wheels[n][7];
        for (int i = 6; i >= 0; i--)
            wheels[n][i + 1] = wheels[n][i];
        wheels[n][0] = temp;
    }
}
/*
class pair{
    int whichtopni, d;
    pair(int whichtopni, int d){
        this.whichtopni = whichtopni;
        this.d = d;
    }
}
public class boj_14891 {
    static final int topni_num = 4;
    static final int topni_baqui = 8;
    static int k;//회전 횟수
    static pair[] pairs;//회전 정보 배열

    static int[] check = new int[4];//변화를 체크하는 톱니바퀴 인덱스 1 - 시계, -1 - 반시계, 2 움직이지 않음
    static int[] visited = new int[4];//visited

    static int[] impo = new int[4];//topnis 배열상 12시 방향에 있는 인덱스들 모음

    static int[][] topnis = new int[topni_num][topni_baqui];

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }
*/
/*
1번 톱니바퀴의 12시 방향은 impo[0] = topnis[0][0]
2번 톱니바퀴의 12시 방향은 impo[1] = topnis[1][0]
3번 톱니바퀴의 12시 방향은 impo[2] = topnis[2][0]
4번 톱니바퀴의 12시 방향은 impo[3] = topnis[3][0]

 *//*

    private static void change(int which, int direc){//impo수정
        if (direc == -1)
            impo[which] = (impo[which] + 1) % topni_baqui;//반시계 방향으로 -> 인덱스 + 1
        else if (direc == 1)
            impo[which] = (impo[which] -1 + topni_baqui) % topni_baqui;//시계방향으로 -> 인덱스 - 1
        else//2
            return;
    }

    private static void rotate(int left, int right){
        if (left >= 0){
            if (topnis[left][2] != topnis[left+1][6]){
                check[left] = check[left+1] * -1;
            }
            visited[left] = 1;
        }

        if (right < 4){
            if (topnis[right][6] != topnis[right-1][2]){
                check[right] = check[right-1] * -1;
            }
            visited[right] = 1;
        }
    }

    private static void rotate2(int left, int right, int mid){
        if (left >= 0){
            if (topnis[left][2] != topnis[left+1][6]){
                check[left] = mid * -1;
            }
            visited[left] = 1;
        }

        if (right < 4){
            if (topnis[right][6] != topnis[right-1][2]){
                check[right] = mid * -1;
            }
            visited[right] = 1;
        }
    }

    private static void solve(){
        for(int i = 0 ; i < k; i++){

            pair one = pairs[i];
            int standard = one.whichtopni;
            Arrays.fill(check, 0);
            check[standard] = one.d;//check[톱니바퀴 인덱스] = 변화 방향
            Arrays.fill(visited, 0);

            rotate2(standard-1, standard+1, one.d);
            visited[standard] = 1;

            for(int j = 0 ; j < topni_num; j++){
                if (visited[j] == 0){//check값을 정의하지 않은 톱니바퀴에 대해
                    rotate(j-1, j+1);
                }
            }

            for(int j = 0; j < topni_num ;j++){
                int result = check[j];
                change(j, result);
            }


        }//end of k iteration

        //출력하기
        int answer = 0;
        for(int p = 0 ; p < 4 ; p++){
            if (topnis[p][impo[p]] == 1)//s극이면
            {
                switch(p){
                    case 0:{
                        answer += 1;
                        break;
                    }
                    case 1:{
                        answer += 2;
                        break;
                    }
                    case 2: {
                        answer += 4;
                        break;
                    }
                    case 3:{
                        answer += 8;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = 4;
        int i = 0;
        //첫번째 입력
        while(t-- > 0){
            topnis[i] = Arrays.stream(bf.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            i++;
        }
        //두번째 입력
        k = Integer.parseInt(bf.readLine());
        pairs = new pair[k];
        i = 0;
        t = k;


        while(t-- > 0){
            st = new StringTokenizer(bf.readLine());
            int which = Integer.parseInt(st.nextToken());
            int direct = Integer.parseInt(st.nextToken());
            pairs[i] = new pair(which-1, direct);//톱니바퀴 인덱스, 방향
            i++;
        }

    }
}
*/
