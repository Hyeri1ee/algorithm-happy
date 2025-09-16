
import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();

        System.out.println(sb);
    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < t; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a+b+"\n");
        }
    }
}
