
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, x; // n: 도시의 개수, m: 도로의 개수, k: 최단 거리, x: 출발 도시 번호
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] distance; // 각 도시까지의 최단 거리를 저장할 배열
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        challenge();
    }

    private static void challenge() {
        // x로부터 출발하여 최단 거리가 k인 모든 도시의 번호 오름차순으로 출력
        distance = new int[n + 1]; // 도시 번호는 1부터 시작하므로 n+1 크기로 배열 생성

        // 최단 거리 초기화 (모든 도시를 아직 방문하지 않은 상태로 표시)
        Arrays.fill(distance, -1);

        // BFS 수행
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x); // 시작 도시 추가
        distance[x] = 0; // 시작 도시까지의 거리는 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 도시에서 이동할 수 있는 모든 도시 확인
            for (int next : graph.get(current)) {
                // 아직 방문하지 않은 도시라면
                if (distance[next] == -1) {
                    // 최단 거리 갱신
                    distance[next] = distance[current] + 1;
                    queue.offer(next); // 큐에 추가
                }
            }
        }

        // 최단 거리가 k인 도시들을 오름차순으로 출력
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (distance[i] == k) {
                result.add(i);
            }
        }

        // 결과 출력
        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            Collections.sort(result); // 오름차순 정렬
            StringBuilder sb = new StringBuilder();
            for (int city : result) {
                sb.append(city).append('\n');
            }
            System.out.print(sb.toString());
        }
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 그래프 초기화 (0번 도시부터 n번 도시까지)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
    }
}