package 알고리즘_코딩테스트.dayone.mar27;

import java.io.*;
import java.util.*;

class pair {
    int x, y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        pair pair = (pair) o;
        return x == pair.x && y == pair.y;
    }
}

public class BOJ_31219 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static pair[] points;
    static boolean[] visited;
    static double minTotalDistance = Double.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        points = new pair[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new pair(x, y);
        }

        for (int start = 0; start < n; start++) {
            minTotalDistance = Double.MAX_VALUE;
            dfs(start, start, 0, 0);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(minTotalDistance);
        System.out.println(sb);
    }

    // 깊이 우선 탐색으로 최단 경로 찾기
    private static void dfs(int start, int current, double totalDistance, int visitedCount) {
        visited[current] = true;

        // 모든 점을 방문했다면
        if (visitedCount == n - 1) {
            // 시작점으로 돌아가는 거리 추가
            double finalDistance = totalDistance + getDistance(points[current], points[start]);
            minTotalDistance = Math.min(minTotalDistance, finalDistance);
            visited[current] = false;
            return;
        }

        // 현재 점에서 가장 가까운 점 찾기
        int nearestPoint = -1;
        double minDistance = Double.MAX_VALUE;

        for (int next = 0; next < n; next++) {
            if (!visited[next]) {
                double distance = getDistance(points[current], points[next]);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestPoint = next;
                }
            }
        }

        // 가장 가까운 점으로 이동
        if (nearestPoint != -1) {
            double newDistance = totalDistance + minDistance;
            dfs(start, nearestPoint, newDistance, visitedCount + 1);
        }

        visited[current] = false;
    }

    // 두 점 사이의 거리 계산
    private static double getDistance(pair a, pair b) {
        int diffX = a.x - b.x;
        int diffY = a.y - b.y;
        return Math.sqrt(diffX * diffX + diffY * diffY);
    }
}