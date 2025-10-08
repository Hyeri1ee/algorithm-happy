
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visit = new boolean[100_000+1];
    static long  cnt = 0;

    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        //arr = new int[n];
        int[] temp = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        arr = new int[n+1];
        int offset = 1; //arr[1]부터 채우기
        System.arraycopy(temp, 0, arr, offset, temp.length);
        Arrays.fill(visit, false);

        int start=1;
        int end =1;

        while(start <= n){
            while(end <= n&& !visit[arr[end]]){
                visit[arr[end]] = true;
                end++;
            }
            cnt += (end - start);
            visit[arr[start]] = false;
            start++;

        }//end of while

        System.out.println(cnt);

    }
}
