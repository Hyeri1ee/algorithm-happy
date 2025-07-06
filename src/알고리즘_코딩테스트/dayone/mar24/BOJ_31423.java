package 알고리즘_코딩테스트.dayone.mar24;

import java.io.*;
import java.util.*;

class BOJ_31423 {
    public static List<String> list;
    public static int N, M, K;
    public static boolean close;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s = new String[N + 1];
        int[] nxt = new int[N + 1];
        int[] tail = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            s[i] = br.readLine();
            tail[i] = i;//아직 연결된 것이 없으므로 i가 끝부분
        }
        // 연결리스트 처럼 구현
        for (int i = 1; i < N; i++) {
            String[] parts = br.readLine().split(" ");
            M = Integer.parseInt(parts[0]);
            K = Integer.parseInt(parts[1]);
            // 연결
            // 2 3
            // 1 2
            // 4 5
            // 1 4
            // 2와 3을 연결, 1과 2를 연결, 4와 5를 연결, 1과 4를 연결이다.
            // 1 23 45 가 된다.
            // 결국 연결만 해주고 출력하면 해결.
            // 2->3, 1->2, 4->5, 1->4 에서는 tail이 3이므로 3->4
            nxt[tail[M]] = K;
            tail[M] = tail[K];
            /*
            nxt[tail[M]] = K; → M의 마지막에 K를 붙인다
            tail[M] = tail[K]; → M의 끝부분을 K의 끝부분으로 갱신
             */
        }

        StringBuilder sb = new StringBuilder();
        while(M != 0){
            sb.append(s[M]);
            M = nxt[M];
        }
        System.out.print(sb.toString());
    }
}