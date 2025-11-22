
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int n, m;
    static int[] parent;
    static int count = 0;

    //static LinkedList<Integer>[] graph;

    public static void main(String[] args)throws Exception{

        input();
        solve();
    }
    private static void solve(){

        boolean[] visit = new boolean[n+1];
        int components = 0;
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            if (!visit[root]) {//다른 루트 노드인 경우
                visit[root] = true;
                components++;
            }
        }


        System.out.println(count + components-1);
    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent= new int[n+1];
        //graph = new LinkedList[n+1];

        IntStream.range(0, parent.length)
                .forEach(i -> parent[i] = i);
        for(int i =0 ; i< m ; i++){
            st = new StringTokenizer(bf.readLine());
            //a-b연결할거임
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());

            int parent_a = find(a);
            int parent_b = find(b);
            //근데 최종 부모가 같음
            if (parent_a == parent_b) count++;//끊기
            else{//최종 부모가 다름
                parent[parent_a] = parent_b;
            }
           // graph[a].add(b);
           // graph[b].add(a);
        }
    }
    private static int find(int t){
        if (parent[t] == t) return t;
        parent[t] =  find(parent[t]);
        return parent[t] ;
    }
}
