
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] sum;
    static int[] a;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();

        a[0] = sum[0];
        sb.append(a[0] + " ");
        for(int i =1; i <n; i++){
            a[i] = sum[i] - sum[i-1];
            sb.append(a[i]+" ");
        }

        System.out.println(sb);

    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        sum = new int[n];
        a = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < n ; i ++){
            sum[i] = Integer.parseInt(st.nextToken()) * (i+1);
        }

    }
}
