

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //여름방학 일수
        int M = sc.nextInt(); //리조트 이용 불가날 수
        boolean[] blocked = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int day = sc.nextInt();
            blocked[day] = true;
        }

        // dp[i][c] = i일에 쿠폰 c장 가진 최소 비용
        int[][] dp = new int[N + 6][101]; // N+5일 이후까지 고려 + 쿠폰 최대 100개
        for (int i = 0; i <= N + 5; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        for (int day = 0; day < N; day++) {
            for (int coupon = 0; coupon <= 100; coupon++) {//각 쿠폰 개수마다 가능한 시뮬레이션 시도
                if (dp[day][coupon] == Integer.MAX_VALUE) continue;

                //리조트 이용 불가 → 그냥 넘김
                if (blocked[day + 1]) {
                    dp[day + 1][coupon] = Math.min(dp[day + 1][coupon], dp[day][coupon]);
                } else {
                    //하루 이용권 구매
                    dp[day + 1][coupon] = Math.min(dp[day + 1][coupon], dp[day][coupon] + 10000);

                    //쿠폰으로 하루 이용
                    if (coupon >= 3) {
                        dp[day + 1][coupon - 3] = Math.min(dp[day + 1][coupon - 3], dp[day][coupon]);
                    }

                    //3일권
                    dp[day + 3][coupon + 1] = Math.min(dp[day + 3][coupon + 1], dp[day][coupon] + 25000);

                    //5일권
                    dp[day + 5][coupon + 2] = Math.min(dp[day + 5][coupon + 2], dp[day][coupon] + 37000);
                }
            }
        }

        // 결과: N일까지의 모든 쿠폰 상태 중 최소 비용
        int result = Integer.MAX_VALUE;
        for (int coupon = 0; coupon <= 100; coupon++) {
            result = Math.min(result, dp[N][coupon]);
        }

        System.out.println(result);
    }
}

