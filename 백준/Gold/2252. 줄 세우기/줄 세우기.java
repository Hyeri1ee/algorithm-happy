
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static LinkedList<Integer>[] list;
    static int[] d;
    static boolean[] visited;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        solve();
        System.out.println(sb);
    }
    private static void solve(){

        //진입차수 0인 노드 넣기
        putzeroinqueue();

        //
        while(!queue.isEmpty()){
            int poll = queue.poll();
            if (visited[poll]) continue;

            visited[poll] = true;
            sb.append(poll +" ");

            for(int n : list[poll]){
                d[n]--;
                if (d[n] == 0 && !visited[n]) {//진입차수 = 0, 방문하지 않은 곳
                    queue.add(n);
                }
            }

            //putzeroinqueue();
        }


    }
    private static void putzeroinqueue(){
        for(int i = 1; i < n+1 ; i++){
            if (d[i] == 0 && !visited[i]) {//진입차수 = 0, 방문하지 않은 곳
                queue.add(i);
            }
        }
    }
    private static void input() throws Exception{
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new LinkedList[n+1];
        for(int i =1 ;i <n+1; i++){
            list[i] = new LinkedList<Integer>();
        }
        d = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(visited, false);

        for(int i =0 ; i < m ;i++){
            st=new StringTokenizer(bf.readLine());

            int thisgofirst = Integer.parseInt(st.nextToken());
            int thisgolast = Integer.parseInt(st.nextToken());
            list[thisgofirst].add(thisgolast);
            d[thisgolast]++;
        }
    }
}
