package 알고리즘_코딩테스트.dayone.may1;

import java.io.*;
import java.util.*;

public class boj24511 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] isStack = new int[n];
        int[] values = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            isStack[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (isStack[i] == 0) {//큐
                deque.addLast(values[i]); //큐인 경우만 유지
            }
        }

        int m = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            int newValue = Integer.parseInt(st.nextToken());
            deque.offerFirst(newValue);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
