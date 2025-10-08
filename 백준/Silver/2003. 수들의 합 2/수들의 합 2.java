
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long[] sum;
    static int count = 0;

    public static void main(String[] a) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        sum = new long[n+1];
        for(int i =1 ;i<= n;i++){
            sum[i] = Long.parseLong(st.nextToken()) + sum[i-1];

        }
        int start = 0;
        int end =1;
        long diff ;
        while(end <= n){
            diff = sum[end] - sum[start];
            if (diff < m)
                end++;
            else if (diff > m)
                start++;
            else
            {
                count++;
                start++;
            }
        }

        System.out.println(count);

    }
}
