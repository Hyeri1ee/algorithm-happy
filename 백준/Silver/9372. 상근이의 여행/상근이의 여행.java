
/*
1 2
2 3
3 4
2 5
2 6
 */
import java.io.*;
import java.util.*;

public class Main {
    static int t,n,m;
    static int[][] link;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static long result = 0;

    public static void main(String[] args) throws Exception{
        input();
    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = stoi(bf.readLine());
        for(int test_case = 0 ; test_case < t; test_case++){
            test_input(bf);
            sb.append(solve()+"\n");
            result = 0; //result 초기화
        }

        System.out.println(sb);
    }

    private static long solve(){
        for(int i = 1; i < n+1; i++){
            if (!visited[i]){
                visited[i] = true;
                bfs(i);
            }
        }
        return result;
    }
    private static void bfs(int start){
        for(int i =1; i< n+1; i++){
            if (link[start][i] == 1 && !visited[i]){
                visited[i] = true;
                bfs(i);
                result++;
            }
        }
    }

    private static void test_input(BufferedReader bf)throws  Exception{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        visited = new boolean[n+1];
        link = new int[n+1][];
        for(int i = 1 ; i < n+1; i++){
            link[i] = new int[n+1];
        }
        //m개의 줄에 a,b쌍 입력
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            link[a][b] = 1;
            link[b][a] = 1;
        }


    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
