package 알고리즘_코딩테스트.dayone.mar17;

import java.io.*;
import java.util.*;

class AB{
    int a; int b;

    public AB(int a, int b){
        this.a = a;
        this.b = b;
    }
}
public class BOJ_2251 {


    static int a,b,c;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        input();

    }

    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        c = Integer.parseInt(st.nextToken());
        AB ab = new AB(a, b);



    }
}
