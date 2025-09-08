import java.io.*;
import java.util.*;
public class Main {
    static boolean[] visited;
    static int n , m;
    static pair[] pairs;

    static class pair{
        int a, b;
        public pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        pairs = new pair[m];
        que.add(new int[] {-2,1});//상근

        visited = new boolean[n+1];
        Arrays.fill(visited,false);

        for(int i = 0 ; i <m; i++){

            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pairs[i] = new pair(a,b);
        }

        int count = 0 ;
        while(!que.isEmpty())
        {
            int[] poll = que.poll();
            if (visited[poll[1]]) continue;

            //방문 안햇으면
            visited[poll[1]] = true;
            round(poll);
            count++;
        }


        System.out.println(count - 1);//상근이 제외




    }

    private static void round(int[] a){
        for(pair p : pairs){
            int pa = p.a;
            int pb = p.b;

            if (a[1] == 1){
                //측근이면
                if (a[1]==pa) que.add(new int[] {-1, pb});
                if (a[1]==pb) que.add(new int[] {-1, pa});
            }else if (a[0] == -1){
                //측근의 친구이면
                if (a[1]==pa) que.add(new int[] {0, pb});
                if (a[1]==pb) que.add(new int[] {0, pa});
            }


        }
    }
}
