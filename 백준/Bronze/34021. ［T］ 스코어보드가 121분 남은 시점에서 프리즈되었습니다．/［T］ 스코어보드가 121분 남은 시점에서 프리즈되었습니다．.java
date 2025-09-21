
import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int n, m ,l;
    static int[] s;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());
        while(t-- > 0){
            input(bf, st);
            int min = Integer.MAX_VALUE;
            for(int i = 0 ; i < n; i++){
                if (s[i] != -1){
                    min = Math.min(min, s[i]);
                }
            }

            //l과 Min비교
            min = Math.max(m - min, l);
            sb.append("The scoreboard has been frozen with ");
            if (min == 1)
                sb.append(min + " minute remaining.\n");
            else
                sb.append(min +" minutes remaining.\n");
        }

        System.out.println(sb);
    }
    private static void input(BufferedReader bf, StringTokenizer st) throws Exception{


        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        s = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();



    }
}
