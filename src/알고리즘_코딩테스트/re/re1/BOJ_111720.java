package 알고리즘_코딩테스트.re.re1;

import java.io.*;
import java.util.*;
public class BOJ_111720 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        long num = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        char[] arr = st.nextToken().toCharArray();
        for (int i = 0; i < num; i++) {
            answer += Long.parseLong(arr[i]+"");
        }
        System.out.println(answer);
    }
}
