package 알고리즘_코딩테스트.dayone.mar24;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ_2812 {
    static int n, k;
    static Stack<Integer> stack = new Stack<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] str = Arrays.stream(bf.readLine().split(""))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int cnt = 0;
        for(int i = 0; i < str.length; i++){
            while(!stack.isEmpty() && cnt < k && stack.peek() < str[i]) {
                cnt++;
                stack.pop();
            }
            stack.push(str[i]);
        }

        int left = k-cnt;
        while(left-- > 0){
            stack.pop();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < n-k;i++){
            sb.append(stack.pop().toString());
        }

        System.out.println(sb.reverse());

        /*PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); //내림차순
        int i = 0;
        while(size-- > 0){
            queue.add(str[i]);
            i++;
        }

        */


    }
}
