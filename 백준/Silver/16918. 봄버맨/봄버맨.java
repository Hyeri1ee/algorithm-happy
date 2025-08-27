

import java.io.*;
import java.util.*;

/*
문제 : (https://www.acmicpc.net/problem/16918)
2,4 : 짝수 초
모든 부분 0

1초 -> 그대로

3초 , 7초, 11초  ... 
5초, 9초 ...  상하좌우 영향 미치는 거 반영해서 출력

= > n값에 따라서 결과 종류화 할 수 있음



 */
public class Main {
    static int r,c, n;
    static char[][] arr;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        input();


        if (n == 1) {
            print(arr);//그대로 (초기상태)
        } else if (n % 2 == 0) {
            print(fullBomb());//모두 0
        } else if (n % 4 == 3) {
            print(explode(arr));//빵
        } else { //n % 4 == 1
            print(explode(explode(arr)));
        }



    }

    private static void print(char[][] arr){
        for(int i = 0 ; i < r; i++){
            for(int j = 0 ; j < c ;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    static char[][] fullBomb() {
        char[][] filled = new char[r][c];
        for (int i = 0; i < r; i++)
            Arrays.fill(filled[i], 'O');
        return filled;
    }

    static char[][] explode(char[][] map){
        char[][] newMap = fullBomb();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'O') {
                    newMap[i][j] = '.';//빵
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d], ny = j + dy[d];
                        if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                            newMap[nx][ny] = '.';//너도 빵
                        }
                    }
                }
            }
        }
        return newMap;
    }




    private static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        for(int i = 0 ; i < r; i++){
            arr[i] = bf.readLine().toCharArray();
        }
    }
}
