
import java.io.*;
import java.util.*;

/*
cycle[] : cycle이 생기는지 판별하기 위해
done[] : 팀에 속한 사람은 제외하기 위해
 */
public class Main {
    static int T;
    static int n;
    static int[] arr;
    static int[] visited;
    static int[] done;

    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        input();
        System.out.println(sb);
    }

    private static void dfs(int start){

        if (visited[start] == 1){//방문했을 때
            done[start] = 1;
            count++;
        }else{//방문 안했을 때
            visited[start] = 1;
        }

        if (done[arr[start]] == 0){//팀 결성을 못한 경우
            dfs(arr[start]);
        }

        visited[start] = 0;
        done[start] = 1;//팀을 구했든 안 구했든 끝남

    }

    private static void solve(){
        for(int i =1 ; i <= n ; i++)
            if (done[i] == 0)
                dfs(i);//start
       sb.append(n-count).append("\n");
    }

    private static void input() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        int i=1;
        while(T-- > 0){
            n = Integer.parseInt(bf.readLine());
            arr = new int[n+1];
            visited = new int[n+1];
            done = new int[n+1];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=1 ;j <= n; j++ ){
                arr[j] = Integer.parseInt(st.nextToken());

                if(arr[j] == j){
                    done[j] = 1;//자기 자신
                    count++;
                }
            }



            solve();
            count = 0;//초기화
        }
    }
}
