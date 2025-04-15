
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static boolean[] visit;
    static int[] a;

    //input
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{

        while(true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            if (st.countTokens() == 1)
                if(stoi(st.nextToken()) == 0)
                    break;

            input(st);
            solve();
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(){
        dfs(0,0);

    }


    private static void dfs(int s, int depth){
        if (depth == 6){
            for(int val : a){
                sb.append(val +" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = s; i < n; i++){
            if (!visit[i]){
                visit[i] = true;
                a[depth] = arr[i];
                dfs(i,depth+1);
                visit[i] = false;
            }
        }
        return;
    }

    private static void input(StringTokenizer st){
        n = stoi(st.nextToken());
        arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = stoi(st.nextToken());
        }
        visit = new boolean[n];
        a = new int[6];
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
