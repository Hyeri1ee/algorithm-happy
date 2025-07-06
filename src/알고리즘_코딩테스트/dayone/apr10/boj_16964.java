package 알고리즘_코딩테스트.dayone.apr10;

import java.io.*;
import java.util.*;

public class boj_16964 {
    static int n;
    static ArrayList<Integer>[] edge;
    static int[] suggest;
    static boolean[] visited;

    static boolean answer = true;
    static int idx  = 1;
    static int from = -1;

    public static void main(String[] args)throws IOException{
        input();
        solve();

        System.out.println( answer ? "1" : "0");

    }

    private static void solve(){
       int start = suggest[1];

       if (start != 1){
           answer = false;
       }else{
           dfs(1);
       }
    }

    /*
    from : 부모 노드 값
    cur : 현재 노드 값
    idx : 현재 방문한 suggest[] 노드 인덱스
     */
    /*
    dfs(-1, 1, 1)
     */
    private static void dfs(int cur){//-1 ,1, 1  //1, 3, 2
        if (visited[cur])
            return;

        visited[cur] = true; //visited => false, true, false, false, false //visited => false, true, false, true,false
        HashSet<Integer> sets = new HashSet<>();

        //가능한 자식 노드를 모두 저장
        for(int e : edge[cur]){//sets => 2, 3 //sets => nothing
            if (!visited[e])//방문하지 않은 점이면
                sets.add(e);
        }

        if (sets.size() == 0){
            return;
        }

        while(! sets.isEmpty()){//자식노드들을 모두 방문할 때까지
            if (sets.contains(suggest[++idx])){//자식노드 아래에 포함하고 있으면
                sets.remove(suggest[idx]);//자식노드의 모든 걸 다 탐방
                dfs(suggest[idx]);//dfs(3)
            }else{
                answer = false;
                return;
            }
        }



    }


    private static void input()throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        edge = new ArrayList[n+1];
        for(int i =1 ; i < n+1 ;i++)
            edge[i] = new ArrayList<>();


        for(int i = 1; i <= n-1; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int b = Integer.parseInt(st.nextToken());
                edge[a].add(b);
                edge[b].add(a);
            }
        }
        suggest = new int[n+1];

        st = new StringTokenizer(bf.readLine());
        for(int i = 1 ; i <= n; i++){
            suggest[i] = Integer.parseInt(st.nextToken());
        }


        visited = new boolean[n+1];
        Arrays.fill(visited,false);
    }
}
