package 알고리즘_코딩테스트.dayone.mar24;

import java.util.*;
import java.io.*;

public class BOJ_6549 {

    /*
입력

7 2 1 4 5 1 3 3
4 1000 1000 1000 1000
0

출력

8
4000
     */
    static int n;
    static Stack<Integer> stack = new Stack<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static void main(String[] args) throws IOException{
        while(! bf.readLine().equals("0")){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n =  Integer.parseInt(st.nextToken());

            while(n-->0){
                stack.push(Integer.parseInt(st.nextToken()));
            }


        }


    }
}
