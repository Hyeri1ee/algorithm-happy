/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 게임_1072 {
    static int x, y;
    static boolean change = false;
    public static void main(String[] args) throws IOException{
        input();
    }
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        //z 승률 = (y + A) / (x + A)
        long left = y;//이긴 횟수
        long right = x;//이긴 횟수 최댓값
        long mid = 0;
        while(left <= right){
            mid = (left + right) / 2;//이긴 횟수 후보

            double z_result = mid * (1.0) / x;
            if (z_result > y * (1.0) / x)
            {
                change = true;
                right = mid;
                //System.out.println(mid - left);
            }

        }

        if(!change)
            System.out.println(-1);
        else
            System.out.println(mid - x);

    }
}
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long x, y, z;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        z = (y * 100) / x;
    }

    private static void solve() {
        if (z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long newZ = ((y + mid) * 100) / (x + mid);

            if (newZ > z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
