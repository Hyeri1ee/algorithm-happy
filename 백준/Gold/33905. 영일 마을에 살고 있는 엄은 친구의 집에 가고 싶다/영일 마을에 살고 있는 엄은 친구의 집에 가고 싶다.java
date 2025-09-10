import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int cnt = 0;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    static ArrayList<Integer> dontgo = new ArrayList<>();
    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        input();
        solve();

    }

    private static void solve(){
        bfs(1);
        System.out.println(cnt);
    }
    private static void bfs(int s){
        if(!visited[s]){
            visited[s] =true;
            que.add(s);
        }

        while(!que.isEmpty()){
            int p = que.poll();
            for(int can : list[p])
            {
                if (!visited[can] && !isInDongo(can)){
                     visited[can] =true;
                     que.add(can);
                     cnt++;
                }
            }
        }

    }

    private static boolean isInDongo(int s){
        return dontgo.contains(s);
    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n+2];

        //list
        list = new ArrayList[n+2];//n은 친구 수고, 실제로는 n+1명의 집이 나를 포함해서 있어야함
        for(int i = 1; i<= n+1; i++){
            list[i] = new ArrayList<>();
        }

        //받기
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()){
            dontgo.add(Integer.parseInt(st.nextToken()));
        }


    }
}
