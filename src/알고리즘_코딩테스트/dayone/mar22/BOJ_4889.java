package 알고리즘_코딩테스트.dayone.mar22;

/*
입력

}{
{}{}{}
{{{}
---


출력

1. 2
2. 0
3. 1
 */

import java.io.*;
import java.util.*;

public class BOJ_4889 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while(true){
            Deque<String> deque = new LinkedList<>();
            String input = bf.readLine();
            if (input.contains("-"))
                break;
            List<String> list = Arrays.asList(input.split(""));

            /*
            { { => push
            { } => pop
            } { => push
            } } => push
             */
            for (String target : list){
                if (target.equals("{"))
                    deque.add(target);
                else if (target.equals("}")){
                    if (!deque.isEmpty() && deque.getLast().equals("{"))
                        deque.removeLast();
                    else
                        deque.add(target);
                }
            }


            /*
            }{
            }}{{
            }{{{
            {{{{
            }}}}

            {{ 2개를 {} => 1번
            }} 2개를 {} => 1번
            }{ 2개를 {} => 2번
             */
            int count = 0;
            String prev;
            String after;
            while (!deque.isEmpty()){
                prev = deque.pollFirst();
                after = deque.pollFirst();

                if (prev.equals(after)){
                    count++;
                }
                else{// }{
                    count += 2;
                }
            }// end while

            sb.append(++i).append(". ").append(count).append("\n");

        }

        System.out.println(sb);
    }
}
