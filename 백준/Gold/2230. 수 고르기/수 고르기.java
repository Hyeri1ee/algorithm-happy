
import java.util.*;
import java.io.*;


public class Main {
    static int n, m;
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i= 0; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            list.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list);
        int i = 0;int j = 0;
        long gap = Long.MAX_VALUE;
        while(true){
            if (i == n-1 && j == n-1){
                break;
            }

            long t1 = list.get(i);
            long t2 = list.get(j);
            long tgap = Math.abs(t1-t2);
            if (tgap > m){
                gap = Math.min(tgap, gap);
                if (i < n-1)
                    i++;
                else
                    break;
            }else if (tgap == m){
                gap = m;
                break;
            }else {//gap < m
                if (j < n-1)
                    j++;
                else
                    break;

            }
        }

        System.out.println(gap);
    }

}
