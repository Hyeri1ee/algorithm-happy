import java.io.*;
import java.util.*;

public class Main {
    static class bowl{
        int x, y, len;
        public bowl(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n, m;
    static char[][] arr;
    static ArrayList<bowl> answers = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        //input
        input();
        //하나의 점을 중심으로 십자가 만들 수 있는지
        //만들 수 있으면 길이도 얼만큼 늘릴 수 있는지
        for(int i = 0 ; i < n; i++){
            for(int j =0  ; j< m ; j++){
                char center = arr[i][j];
                if (center == '*'){
                    int len = 1;
                    int maxLen = 0;
                    while (surroundedbyStar(i, j, len)){
                       maxLen = len;
                        len++;
                    }
                    if (maxLen > 0) {
                        answers.add(new bowl(i, j, maxLen));
                    }
                }//end of center기준 탐색
            }
        }
        //찾은거대로 수정
        for (bowl b : answers) {
            arr[b.x][b.y] = ')';
            for (int l = 1; l <= b.len; l++) {
                for(int d = 0 ; d < 4; d++){
                    int nx = b.x + dx[d]*l;
                    int ny = b.y + dy[d]*l;
                    arr[nx][ny] = ')';
                }
            }
        }


        //최종적으로 한번 돌며 * 존재하는지 확인
        for(int i =0  ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if (arr[i][j] == '*')
                {
                    System.out.println(-1);//존재하면
                    return;
                }
            }
        }
        //존재안한다면
        StringBuilder sb = new StringBuilder();
        int finalLen = 0;
        for (bowl b : answers) {
            int len = b.len;  // 임시 변수 사용
            while (len > 0) {
                finalLen++;
                sb.append((b.x+1) + " " + (b.y+1) + " " + len + "\n");
                len--;
            }
        }


        System.out.println(finalLen);
        System.out.println(sb);


    }

    private static boolean surroundedbyStar(int i, int j, int len) {
        for(int x = 0 ; x < 4; x++){
            int nx = i+dx[x]*len;
            int ny = j+dy[x]*len;
            if (isInSize(nx, ny) &&  ( arr[nx][ny] == '*')){
                continue;
            }else{
                return false;
            }

        }

        return true;
    }

    private static boolean isInSize(int nx, int ny) {
        return nx>=0 && nx < n && ny >= 0 && ny  < m ;
    }


    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr =new char[n][m];
        for(int i = 0 ; i < n; i ++){
            arr[i] = bf.readLine().toCharArray();
        }

    }
}
