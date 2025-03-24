
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

class Main { // Boj_31423_신촌 통폐합 계획
    // 결국 하나로 만들어져야 하므로, 연결되는 순서만 알면 된다.
    public static List<String> list;
    public static int N, M, K;
    public static boolean close;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] s = new String[N + 1];
        int[] nxt = new int[N + 1]; // 다음 연결할곳
        int[] tail = new int[N + 1]; // 뭉텅이 끝 지점 표기

        for (int i = 1; i <= N; i++) {
            s[i] = br.readLine();
            tail[i] = i;
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
            // 1 4 이므로
            // 2와 3을 연결, 1과 2를 연결, 4와 5를 연결, 1과 4를 연결이다.
            // 1 23 45 가 된다.
            // 결국 연결만 해주고 출력하면 해결.
            // 2->3, 1->2, 4->5, 1->4 에서는 tail이 3이므로 3->4
            nxt[tail[M]] = K;
            tail[M] = tail[K];
        }

        StringBuilder sb = new StringBuilder();
        while(M != 0){
            sb.append(s[M]);
            M = nxt[M];
        }
        System.out.print(sb.toString());
    }
}