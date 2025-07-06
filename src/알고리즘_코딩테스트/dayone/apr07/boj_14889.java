package 알고리즘_코딩테스트.dayone.apr07;

import java.io.*;
import java.util.*;

public class boj_14889 {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        combination(0, 0);
        System.out.println(minDiff);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        visited = new boolean[n];
    }

    private static void combination(int depth, int start) {
        if (depth == n / 2) {
            calculateDiff();
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void calculateDiff() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += arr[i][j] + arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += arr[i][j] + arr[j][i];
                }
            }
        }

        int diff = Math.abs(startTeam - linkTeam);
        minDiff = Math.min(minDiff, diff);
    }
}
