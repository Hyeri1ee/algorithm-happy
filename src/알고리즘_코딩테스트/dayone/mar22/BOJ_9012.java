package 알고리즘_코딩테스트.dayone.mar22;

import java.io.*;
import java.util.*;

public class BOJ_9012 {
    static int n;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(bf.readLine());
        while(n-- >0){

            Stack<String> stack = new Stack<>();
            List<String> ch = Arrays.asList(bf.readLine().split(""));
            int exceptionint = 0;

            for (int i = 0 ; i < ch.size(); i++){
                String c = ch.get(i);
                if (c.equals("("))
                    stack.add(ch.get(i));
                else{
                    if (!stack.isEmpty())
                        stack.pop();
                    else
                        exceptionint = 1;

                }

            }

            if (!stack.isEmpty() || exceptionint == 1){//비지 않으면
                sb.append("NO").append("\n");
            }else
                sb.append("YES").append("\n");
        }

        System.out.println(sb);
    }

}
