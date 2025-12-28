import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static Node[] tree;

    static class Node {
        int min, max;
        Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        tree = new Node[4 * N];
        init(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Node res = query(1, 1, N, a, b);
            sb.append(res.min).append(" ").append(res.max).append("\n");
        }

        System.out.print(sb);
    }
//초기화
    static Node init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = new Node(arr[start], arr[start]);
        }
        int mid = (start + end) / 2;
        Node l = init(node * 2, start, mid);
        Node r = init(node * 2 + 1, mid + 1, end);

        return tree[node] = new Node(
            Math.min(l.min, r.min),
            Math.max(l.max, r.max)
        );
    }
//쿼리
    static Node query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        Node l = query(node * 2, start, mid, left, right);
        Node r = query(node * 2 + 1, mid + 1, end, left, right);

        return new Node(
            Math.min(l.min, r.min),
            Math.max(l.max, r.max)
        );
    }
}
