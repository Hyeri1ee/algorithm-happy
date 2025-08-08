
import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] arr;
    static boolean[] visit;

    static int count = 0;

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }
    private static void solve(){
        visit[0] = true;
        dfs(0);
    }

    private static void dfs(int person){
        visit[person] = true;

        if (person == k) {
            System.out.println(count);
            return;
        }

        int i = 0;

        while(arr[person][i] == 0){
            i++;
        }

        person = i;
        if (!visit[person])
            count++;
        else{
            System.out.println(-1);
            return;
        }
        dfs(person);
    }
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = stoi(st.nextToken());
        k = stoi(st.nextToken());

        arr = new int[n][];
        visit = new boolean[n];
        Arrays.fill(visit, false);


        for(int i = 0 ;i < n ; i++){
            arr[i] = new int[n];
        }

        //입력
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            int in = stoi(st.nextToken());
            arr[i][in] = 1;
        }

    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
