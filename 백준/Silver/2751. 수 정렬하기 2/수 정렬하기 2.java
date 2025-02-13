
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] tmp;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr = new int[n + 1];
        tmp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        //병합 함수
        mergesort(1, n);//1,n : 인덱스
        for (int i = 1 ; i < n+1 ; i++){
            System.out.println(arr[i]);
        }
    }

    private static void mergesort(int s, int e) {
        if (e <= s)
            return;

        int m = s + (e - s) / 2;
        mergesort(s, m);
        mergesort(m + 1, e);
        merge(arr, tmp, s, m, e);

    }

    private static void merge(int[] arr, int[] tmp, int left, int m, int end) {
        for (int i = left; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = left;
        int part2 = m + 1;
        int index = left;
        while (part1 <= m && part2 <= end) {
            if (tmp[part1] <= tmp[part2]){
                arr[index] = tmp[part1];
                part1++;
            }else{
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0 ; i  <= m-part1; i++){//part2가 미리 끝난 경우
            arr[index+i] = tmp[part1+i];
        }
    }
}
