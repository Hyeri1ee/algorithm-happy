package 알고리즘_코딩테스트.dayone.feb15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static int n,m;
    static boolean[] visited;
    static ArrayList<Integer>[] a;
    public static void main(String[] args) throws IOException{
        input();
        int count = 0;

        for(int i = 1 ; i < n+1; i++){
            if (!visited[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void dfs(int start){
        if (! visited[start]){
            visited[start] = true;
            for (int i : a[start]){
                if (visited[i] == false){
                    dfs(i);
                }
            }

        }

    }

    public static void input() throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        a = new ArrayList[n+1];

        for(int i =1 ; i < n+1; i++){
            a[i] = new ArrayList<>();
        }
        for(int i = 0 ; i <= m-1 ; i++){//edge
            st = new StringTokenizer(bf.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            a[p1].add(p2);
            a[p2].add(p1);
        }
    }
}
