package 알고리즘_코딩테스트.dayone.apr28;
import java.io.*;
import java.util.*;

public class boj14425 {

    static int n,m;
    static HashSet<String> sets = new HashSet<>();

    public static void main(String[] args)throws Exception{
        int result = 0 ;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        while(n-- > 0){
            String input = bf.readLine();
            sets.add(input);
        }

        while(m-- > 0){
            String input = bf.readLine();
            if (sets.contains(input))
                result++;
        }

        System.out.println(result);
    }

}
