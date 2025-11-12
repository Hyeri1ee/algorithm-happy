
import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int n, m;
    static int[] u;
    static boolean[] hascycle;
    static StringBuilder sb = new StringBuilder();
    static int num = 0;
    public static void main(String[]args) throws Exception{
        input();
        System.out.println(sb);
    }
    private static int find(int x){
        if(u[x] == x) return x;
        return u[x] = find(u[x]);
    }
    private static void process(){
        Set<Integer> roots = new HashSet<>();
        for(int i = 1; i <= n ; i++){
            int root = find(i);
            if (!hascycle[root]) roots.add(root);
        }

        long count = roots.size();
        if (count == 1){
            sb.append("Case " + num +": " + "There is one tree.\n");
        }else if (count == 0)
            sb.append("Case " + num +": No trees.\n");
        else
            sb.append("Case " + num +": " + "A forest of " + count +" trees.\n");




    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            num++;
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0)
                break;
            u = new int[n+1];
            hascycle = new boolean[n+1];
            IntStream.range(0, u.length)
                    .forEach(i -> u[i] = i);
            //Arrays.setAll(u, i -> i+1);
            for(int j = 0; j < m ; j++){
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int px = find(x);
                int py = find(y);

                if (px == py){
                    hascycle[px] = true;
                }else{
                    u[py] = px;
                    hascycle[px] |= hascycle[py];
                }
            }
            process();
        }
    }
}
