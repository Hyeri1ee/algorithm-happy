import java.util.*;

class Solution {
    static final int INF = 1000000;

    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int[] item : info) {
            int aCost = item[0];
            int bCost = item[1];

            int[] next = new int[m];
            Arrays.fill(next, INF);

            for (int b = 0; b < m; b++) {
                if (dp[b] == INF) continue;

                // A가 훔치는 경우
                int newA = dp[b] + aCost;
                if (newA < n) {
                    next[b] = Math.min(next[b], newA);
                }

                // B가 훔치는 경우
                if (b + bCost < m) {
                    next[b + bCost] = Math.min(next[b + bCost], dp[b]);
                }
            }
            dp = next;
        }

        int answer = INF;
        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[b]);
        }

        return answer == INF ? -1 : answer;
    }
}
