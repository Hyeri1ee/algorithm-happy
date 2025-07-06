package 알고리즘_코딩테스트.dayone.mar27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_32751 {
    static int n;
    static int[] arr;
    static String str;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static boolean answer = true;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr = new int[4];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        str = bf.readLine();

        check();

        System.out.println(answer ? "Yes" : "No");
    }

    public static void check() {
        // 첫 문자가 'a'가 아니면 바로 false
        if (str.charAt(0) != 'a') {
            answer = false;
            return;
        }

        // 길이가 1이면 true
        if (n == 1) {
            return;
        }

        int[] count = new int[4];
        count[0] = arr[0] - 1;
        count[1] = arr[1];
        count[2] = arr[2];
        count[3] = arr[3];

        char prev = 'a';
        for (int i = 1; i < n; i++) {
            char curr = str.charAt(i);
            int index = "abcd".indexOf(curr);

            if (prev == curr) {
                answer = false;
                return;
            }

            count[index]--;

            if (count[index] < 0) {
                answer = false;
                return;
            }

            prev = curr;
        }


    }
}