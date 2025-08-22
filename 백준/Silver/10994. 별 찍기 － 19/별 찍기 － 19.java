

import java.util.*;

/*
구현 문제

1
밖가로 : 1
밖세로 : 1 = 1 + 4 ( 1 - 1)

2
밖가로 : 5
밖세로 : 5  = 1 + 4 ( 2 - 1)

3
밖가로 : 9
밖세로 : 9 = 1 + 4 (3 - 1)

4
밖가로 : 13
밖세로 : 13 = 1 + 4 (4 - 1)
 */
public class Main {
    static int n;
    static char[][] arr;
    static StringBuilder sb =  new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int len = 1 + 4*(n-1);
        arr = new char[len][len];

        //초기화
        for(int i = 0 ; i < len ; i++)
            Arrays.fill(arr[i], ' ');

        //* 넣기
        dfs(0,0,len);


        for(int i  = 0 ; i < len ; i++){
            for(int j = 0 ; j < len ; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y, int l){
        //break 조건
        if (l == 1 )
        {
            arr[x][y] = '*';
            return;
        }

        for(int i = x; i < x + l; i++){
            if (i == x || i == x + l-1)//1행, l행
                Arrays.fill(arr[i], y, y+l,'*');
            else{
                arr[i][y] = '*';
                arr[i][y+l-1] = '*';
            }
        }

        //l에 대해서 채워넣은후
        dfs(x+2, y+2, l - 4);
    }
}
