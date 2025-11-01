
import java.io.*;
import java.util.*;

public class Main {
    /*
    순서를 못 정하는 경우는 무엇인가
    => queue.isEmpty() 인데 D[]의 값이 0이 아닌 경우
     */
    static BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static LinkedList<Integer>[] graph;
    static int[] d;
    static boolean[] visited;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        input();//입력

        solve();//풀이

        print();

    }

    //출력
    static void print(){

        boolean allzero= Arrays.stream(d).allMatch(x -> x== 0);
        if (!allzero) System.out.println(0);
        else System.out.println(sb);
    }

    //풀이
    static void solve(){
        //초기 진입차수 = 0 인 노드 queue에 넣기
        putzerochasooinqueue();

        while(!queue.isEmpty()){
            int poll = queue.poll();
            if (visited[poll]) continue;


            visited[poll] = true;
            sb.append(poll).append("\n");

            for(int target : graph[poll]){
                d[target]--;
                if (!visited[target] && d[target] == 0){
                    queue.add(target);
                }
            }
        }
    }

    //queue에 초기 진입차수 0인거 넣기
    static void putzerochasooinqueue(){
        for(int i = 1; i < n+1; i++){
            if (! visited[i] && d[i] == 0){
                queue.add(i);
            }
        }
    }
    //입력
    static void input() throws Exception{
        st= new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //초기화
        graph = new LinkedList[n+1];
        for(int i = 1; i < n+1; i++){
            graph[i] = new LinkedList<>();
        }
        d = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(visited, false);

        for(int i = 0; i < m; i++){
            st=new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            //System.out.println("num : " + num);

            int prev = Integer.parseInt(st.nextToken());
            //System.out.println("prev " +i + " : " + prev);
            int next = -1;
            for(int j = 0; j < num-1; j++){
                next = Integer.parseInt(st.nextToken());
                //System.out.println("next " +j + " : " + next);
                graph[prev].add(next);
                d[next]++;//진입차수 +1

                prev = next;
            }


        }
    }
}
