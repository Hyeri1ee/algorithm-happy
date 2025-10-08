import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static long[] sum;
    public static void main(String[] ar) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        sum = new long[n+1];
        st = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(st.nextToken());
        sum[1] = a;
        for(int i =2 ;i<n+1;i++){
            long aa = Long.parseLong(st.nextToken());
            sum[i] = aa + sum[i-1];
        }
        //debug
        /*
        for(int i =0 ; i < n ; i++)
            System.out.print(sum[i] + " ");

         */

        int start = 0 ;
        int end = 0;
        long diff = -1;
        int mindiff = Integer.MAX_VALUE;
        while(end < n+1){


            diff = sum[end] - sum[start];

            if (diff  < s)
            {
                end++;
            }
            else if (diff >= s)
            {
                mindiff =Math.min( end-start, mindiff);
                //end++;
                start++;
            }

        }

        //최종
        System.out.println(mindiff == Integer.MAX_VALUE ? 0 : mindiff);
    }
}
