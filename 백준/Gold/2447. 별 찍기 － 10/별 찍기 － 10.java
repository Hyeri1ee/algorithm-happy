
import java.io.*;
import java.util.*;
/*
dfs(0,0,27 = 한변의 길이)
	0) 한변의 길이가 3 인 경우 return
	1) 변 가장자리들 별 채우기
	2) 내부의 경우 (한변의 길이 != 27)
		0,0 -> 1,1
		dfs(1,1,9) dfs(1, 1+9-1,9) dfs(1, 1+9-1+9-1,9)
		dfs(1+9-1,1,9) dfs(1+9-1,1+9-1,9) dfs(1+9-1,1+9-1+9-1,9)
		 .... 3개 더

 */
public class Main {
    static int n;
    static char[][] maps;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve(){
        dfs(0,0,n);
        print();//결과 출력
    }

    private static void dfs(int x, int y, int size) {
        if (size == 1) {
            maps[x][y] = '*';
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 가운데는 비워야 함
                if (i == 1 && j == 1) continue;
                dfs(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }


    /*private static void check(int x, int y, int len){
        if (len == 3){
            for(int i = 0 ; i < len ; i++){//
                if ( i== 0 || i == len-1){
                   for(int k = 0; k < len; k++){
                       maps[x+i][k] = '*';
                   }
                }else {
                    for(int k = 0; k < len; k++){
                        maps[x + i][y+k] = '*';
                        maps[x + len-1][y+k] = '*';
                    }
                }
            }
            return;
        }else{//len > 3인 경우
            int newLen = len / 3;
            *//*
            1 4 5
            2   6
            3 7 8
             *//*
            check(x,y,newLen); //1
            check(x+newLen-1, y+newLen-1, newLen); //2
            check(x+2 * (newLen-1), y+2*(newLen-1), newLen); //3
            check(x, y+newLen-1, newLen); //4
            check(x, y+2*(newLen-1), newLen); //5
            check(x+newLen-1, y+2*(newLen-1), newLen);//6
            check(x+2*(newLen-1), y+newLen-1, newLen); //7
            check(x+2*(newLen-1), y+2*(newLen-1), newLen);//8

        }

    }*/

    private static void print(){
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if (maps[i][j] == '*')
                    sb.append('*');
                else
                    sb.append(' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void input()throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(bf.readLine());
        maps = new char[n][];
        for(int i = 0 ; i < n ; i++){
            maps[i] = new char[n];
        }
    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
