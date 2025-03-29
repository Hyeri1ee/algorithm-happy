
import java.io.*;
import java.util.*;

public class Main {
/*
10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10

3 0 0 1 2 0 0 2
 */
    static int n, m;
    static int[] arr, srr;
    static BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        input();

        solve();
    }
    private static void solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr);

        for(int i = 0 ; i < m; i++){
           int target = srr[i];
          int lower_bound = lower(-1, n, target);
          int upper_bound = upper(-1, n, target);
          int size = upper_bound- lower_bound;
          sb.append(size+" ");
        }

        System.out.println(sb);

    }
    /*
    0 1 2 3  4  5   6   7  8 9
    6 3 2 10 10 10 -10 -10 7 3
    10 찾기

    left = -1, right = 10, mid = 4
    right = 4, left = -1

    left = -1, right = 4, mid = 1
    left = 2, right = 4

    left = 2, right = 4, mid = 3
    right = 3, left = 2

    left = 2, right = 3, mid = 2
    left = 3, right = 3
     */

    private static int lower(int left, int right, int target){
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }
    /*
    0 1 2 3  4  5   6   7  8 9
    6 3 2 10 10 10 -10 -10 7 3
    10 찾기

    left = -1, right = 10, mid = 4
    left = 4, right = 10

    left = 4, right = 10, mid = 7
    left = -1, right = 3

    left = 2, right = 4, mid = 3
    right = 3, left = 2

    left = 2, right = 3, mid = 2
    left = 3, right = 3
     */

    private static int upper(int left, int right, int target){
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        srr = new int[m];
        st = new StringTokenizer(bf.readLine());
        i = 0;

        while(st.hasMoreTokens()){
            srr[i] = Integer.parseInt(st.nextToken());
            i++;
        }


    }
}
