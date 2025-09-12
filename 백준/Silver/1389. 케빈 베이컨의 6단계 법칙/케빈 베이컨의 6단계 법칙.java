

import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] list;
    static int maxperson = 0;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] ar)throws Exception{

        input();

        for(int i = 1; i < n+1; i++){//i사람의 케빈베이컨 수 구하기
            boolean[] visited = new boolean[n+1];
            int[] i_kabin = new int[n+1];
            Queue<int[]> que = new LinkedList<>();
            visited[i] = true;
            que.add(new int[]{i, 0});

            while(!que.isEmpty()){
                int[] poll = que.poll();
                int node = poll[0];
                int dist = poll[1];
                i_kabin[node] = dist;

                for(int next : list[node]){
                    if(!visited[next]){
                        visited[next] = true;
                        que.add(new int[]{next, dist + 1});
                    }
                }
            }
            

            int cnt = 0 ;//i사람의 케빈수
            for(int k = 1; k<= n; k++){
                cnt += i_kabin[k];
            }
            if (max > cnt)
            {
                max = cnt;
                maxperson = i;
            }

        }

        System.out.println(maxperson);

    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }

        //n == 0인 경우
        for(int i = 1 ; i <= m; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
    }
}
