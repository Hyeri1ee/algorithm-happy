
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<Integer> que  = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[]args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        for(int i = 0 ; i < n ; i++){
            int t = Integer.parseInt(bf.readLine());
            if (t == 0)
            {
                if (!que.isEmpty())
                    sb.append(que.poll()+"\n");
                else
                    sb.append("0\n");
            }else{
                que.add(t);
            }
        }
        System.out.println(sb);

    }


}
