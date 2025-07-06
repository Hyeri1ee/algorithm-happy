package alkon_challenge.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class map {
    int x;
    int y;

    public map(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class two {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static ArrayList<map> pre = new ArrayList<>(); // 초기화 추가
    static ArrayList<map> fut = new ArrayList<>(); // 초기화 추가

    public static void main(String[] args) throws IOException {
        input();
        challenge();
    }

    private static void challenge() {
        map current = new map(0, 0);
        int current_num = m;
        int answer = 0;

        while (current_num-- > 0) {
            int max = 0;
            int maxIndex = -1;
            for (int i = 0; i < pre.size(); i++) {
                int cand = calculate(pre.get(i), current);
                if (max < cand) {
                    max = cand;
                    maxIndex = i;
                }
            }

            if (maxIndex != -1) {
                current = pre.get(maxIndex);
                pre.remove(maxIndex);

                if (!fut.isEmpty()) {
                    pre.add(fut.remove(0));
                }

                answer += max;
            }
        }

        System.out.println(answer); // 결과 출력 추가
    }

    private static int calculate(map m, map current) {
        int dx = m.x - current.x;
        int dy = m.y - current.y;
        return dx * dx + dy * dy;
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pre.add(new map(x, y));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            fut.add(new map(x, y));
        }
    }
}