package alkon_challenge.helloalkon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class D {
    static int n;
    static int[] arr;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int k = 2; k <= n; k++) {
            for(int i = 1; i <= n-k+1; i++) {
                int[] ori = new int[k];
                int[] sub = new int[k];

                for(int j = 0; j < k; j++) {
                    ori[j] = arr[i+j];
                    sub[j] = arr[i+j];
                }

                Arrays.sort(sub);

                int midIndex = (k-1)/2;
                if (ori[midIndex] == sub[midIndex]) {
                    System.out.println("YES");
                    return;
                }
            }
        }

        System.out.println("NO");
    }
}