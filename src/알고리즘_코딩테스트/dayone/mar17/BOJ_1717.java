package 알고리즘_코딩테스트.dayone.mar17;

import java.io.*;
import java.util.*;

public class BOJ_1717 {
    static int n, m;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 수
        m = Integer.parseInt(st.nextToken()); // 연산의 수

        parent = new int[n + 1]; // 부모 배열 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i; // 처음엔 각 노드가 자기 자신을 부모로 갖는다.
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (check == 0) {
                union(a, b); // union 연산
            } else {
                find(a, b); // find 연산
            }
        }
    }

    // Union 함수: 두 노드를 같은 집합으로 합침
    private static void union(int a, int b) {
        int rootA =a;
        int rootB =b;

        if (parent[rootA] != parent[rootB]) {
            if (rootA < rootB) {
                parent[rootB] = rootA; // rootA가 더 작으면 rootB의 부모를 rootA로 설정
            } else {
                parent[rootA] = rootB; // rootB가 더 작으면 rootA의 부모를 rootB로 설정
            }
        }
    }


    // Find 함수: 두 노드가 같은 집합에 속하는지 확인
    private static void find(int a, int b) {
        int rootA = a;
        int rootB = b;

        //경로 압축

        if (parent[rootA] == parent[rootB]) {
            sb.append("YES\n"); // 같은 집합이면 YES
        } else {
            sb.append("NO\n"); // 다른 집합이면 NO
        }
    }
}
