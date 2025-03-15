
import java.io.*;
import java.util.*;
/*
5 4
3 1
3 2
4 3
5 3

graph 에는

1 3
2 3
3 4 5
4
5

 */

/*
result[] 배열
1 1 0 0 0
2 2 1 0 0
3 3 2 0 0
 */

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        challenge();

    }

    private static void challenge() {
        int[] result = new int[n+1];

        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            Queue<Integer> queue = new LinkedList<>();

            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                result[i]++;

                for (int next : graph.get(current)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }

                }
            }
        }

        // Find maximum value
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (max < result[i]) {
                max = result[i];
            }
        }

        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        // Remove trailing space
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }

        System.out.println(sb);
    }

    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1 ; i  <= n+1 ; i++){
            graph.add(new ArrayList<>());
        }


        for (int i = 0 ; i < m ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }
    }
}
