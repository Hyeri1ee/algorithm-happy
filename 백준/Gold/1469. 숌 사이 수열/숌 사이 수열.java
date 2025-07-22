
import java.util.*;
import java.io.*;

/*
1. X에 들어있는 모든 수는 숌 사이 수열 S에 정확히 두 번 등장해야함
2. X에 등장하는 수가 i라면, S에서 두 번 등장하는 i사이에는 수가 i개 등장

dfs 문제
 */
public class Main {
    static int n;
    static int[] arr;
    static boolean[] visit;
    
    static int[] ans;
    static boolean found = false;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        input();
        solve();
    }
    private static void solve(){
        dfs(0);
        if (!found) {
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }
    }
    
    private static void dfs(int depth){
        if (found) return;

        if (depth == 2*n){
            sb = new StringBuilder();
            for(int val : ans){
                sb.append(val+ " ");
            }
            found = true;
            return;
        }

        if (ans[depth] != -1) {
            dfs(depth + 1);
            return;
        }
        
        for(int i = 0 ; i < n; i++){
            if (visit[i]) continue;

            if (depth + arr[i] + 1 < n * 2 && ans[depth] == -1 && ans[depth + arr[i] + 1] == -1) {
                visit[i] = true;
                ans[depth] = ans[depth + arr[i] + 1] = arr[i];
                dfs(depth + 1);
                ans[depth] = ans[depth + arr[i] + 1] = -1;
                visit[i] = false;
            }
        }

    }

    private static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(bf.readLine());
        arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(arr); //오름차순으로 정렬
        visit = new boolean[n];
        ans = new int[2*n];
        Arrays.fill(ans, -1);
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
