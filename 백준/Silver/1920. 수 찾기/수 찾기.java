
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] a;
    static int[] check;

    public static void main(String[] args) throws IOException {

        //n 입력, n개 정수 입력
        //m입력, m개 정수 입력
        input();

        //m이 n개 정수 배열에 속해있는지 확인 출력
        for (int i = 0; i < m; i++) {
            System.out.println(binarySearch(check[i]));
        }


    }

    private static int binarySearch(int target) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < target)
                low = mid+1;
            else if (a[mid] > target)
                high = mid-1;
            else
                return 1;
        }
        return 0;
    }

    private static void input() throws IOException {
        n = Integer.parseInt(bf.readLine());
        a = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //a 정렬
        Arrays.sort(a);
        m = Integer.parseInt(bf.readLine());
        check = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
