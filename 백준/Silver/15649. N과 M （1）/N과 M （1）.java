
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
       input();
       solve();
    }
    private static void solve(){
        dfs(0);
        System.out.println(sb);
        return;
    }
    private static void dfs(int de){
        if (de == m){
            for (int val : arr){
                if (val != 0)
                    sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[de] = i + 1;
                dfs(de + 1);
                visit[i] = false;
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        arr = new int[n];
        visit = new boolean[n];
    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}