package 알고리즘_코딩테스트.dayone.mar18;

import java.io.*;
import java.util.*;

public class BOJ_1707 {
    static int T;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(sb);
    }

    public static void input() throws IOException {
        T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수 입력


        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken()); // 정점의 수
            int e = Integer.parseInt(st.nextToken()); // 간선의 수

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }

            // 간선 정보 입력
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(bf.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                list.get(left).add(right);
                list.get(right).add(left);
            }

            // 이분 그래프를 확인하기 위한 배열
            int[] checkbipartite = new int[v + 1];
            Arrays.fill(checkbipartite, -1); // -1로 초기화 (방문하지 않은 상태)

            boolean isBipartite = true;

            // 모든 노드에 대해 DFS 시작
            for (int i = 1; i <= v; i++) {
                if (checkbipartite[i] == -1) { // 아직 방문하지 않았다면
                    if (!dfs(i, 0, checkbipartite, list)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            // 결과 출력
            if (isBipartite) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
    }

    // DFS 함수
    private static boolean dfs(int node, int color, int[] check, ArrayList<ArrayList<Integer>> list) {
        check[node] = color; // 현재 노드에 색을 칠함 0 아니면 1

        for (int neighbor : list.get(node)) {
            if (check[neighbor] == -1) { // 아직 방문하지 않았다면
                // 색을 반대로 칠하고 DFS
                if (!dfs(neighbor, 1 - color, check, list)) {
                    return false;
                }
            } else if (check[neighbor] == check[node]) {
                // 이웃 노드와 같은 색이면 이분 그래프가 아님
                return false;
            }
        }
        return true;
    }
}
