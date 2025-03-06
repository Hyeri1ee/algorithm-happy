import java.util.*;
import java.io.*;

/**
 입력

 5
 1 3 2 -1
 2 4 4 -1
 3 1 2 4 3 -1
 4 2 4 3 3 5 6 -1
 5 4 6 -1
 */
class Node{
    int value;
    int distance;

    public Node(int value,  int distance){
        this.value = value;
        this.distance = distance;
    }
}
public class Main {

    static int result = 0;
    static int farthestNode = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //노드 개수
        int n = Integer.parseInt(bf.readLine());

        //트리 초기화
        List<Node>[]  tree = new ArrayList[n+1];
        for (int i = 1; i < n+1 ; i++){
            tree[i] = new ArrayList<>();
        }

        // 트리 생성
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int node = Integer.parseInt(st.nextToken());

            while (true) {
                int connectedNode = Integer.parseInt(st.nextToken());
                if (connectedNode == -1) break;

                int weight = Integer.parseInt(st.nextToken());
                tree[node].add(new Node(connectedNode, weight));
            }
        }

        // 1. 아무 노드(여기서는 1)에서 시작해 가장 먼 노드 찾기
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        dfs(tree, visited, 0, 1);

        // 2. 가장 먼 노드에서 다시 시작해 최대 거리 찾기
        visited = new boolean[n + 1];
        visited[farthestNode] = true;
        result = 0; // 결과 초기화
        dfs(tree, visited, 0, farthestNode);

        System.out.println(result);

    }

    private static void dfs(List<Node>[] tree, boolean[] visited, int sum, int start){
        if (sum > result) {
            result = sum;
            farthestNode = start;
        }

        // 시작점에서 인접 노드 탐색
        for (Node node : tree[start]) {
            if (!visited[node.value]) {
                // 방문 체크
                visited[node.value] = true;
                // DFS 수행
                dfs(tree, visited, sum + node.distance, node.value);
            }
        }
    }


}
