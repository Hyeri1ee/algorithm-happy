package 알고리즘_코딩테스트.re.one;

import java.io.*;
import java.util.*;
public class BOJ_111720 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        long num = Integer.parseInt(st.nextToken());
        Long[] arr = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            num += Integer.parseInt(st.nextToken());
        }
        System.out.println(answer);
    }
}
