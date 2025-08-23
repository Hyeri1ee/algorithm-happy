
import java.io.*;
import java.util.*;

/*
4 4
3 0 1 4
      1
1     1
1     1
1 _ 1 1


4 8
3 1 2 3 4 1 1 2
        1
1 0 0 1 1
1 0 1 1 1 0 0 1
1 1 1 1 1 1 1 1

맨 아래쪽 왼쪽부터 빈 공간(0)이 있고 1 ---- 1 이면 숫자 세기
 */
public class Main {
    static int h, w;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        h = Integer.parseInt(st.nextToken()); // 4
        w = Integer.parseInt(st.nextToken()); // 4
        st = new StringTokenizer(bf.readLine()); //3 0 1 4

        arr = new int[h][w];
        int i = h-1;
        for (int col = 0; col < w; col++) {
            int a = Integer.parseInt(st.nextToken()); //이 열의 블록 개수
            for (int row = h-1; row >= h-a; row--) {
                arr[row][col] = 1;
            }
        }

        //맨 아래쪽 왼쪽부터 빈 공간(0)이 있고 1 ---- 1 이면 숫자 세기
        int ans = 0;//최종 반영
        for(int k = 0 ; k < h; k++){
            int temp = 0;
            boolean started = false;
            for (int p = 0; p < w; p++) {
                if (arr[k][p] == 1) {
                    if (!started) {
                        started = true; //첫 번째 1 발견
                    } else {
                        ans += temp; //두 번째 이후의 1이면 temp를 더한다
                        temp = 0;    //초기화
                    }
                } else if (started) {
                    temp++;
                }
            }

        }//end of for


        System.out.println(ans);
    }
}
