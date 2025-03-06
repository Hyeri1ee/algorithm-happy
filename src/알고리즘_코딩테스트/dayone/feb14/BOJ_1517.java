package 알고리즘_코딩테스트.dayone.feb14;

import java.io.*;
import java.util.*;


public class BOJ_1517 {
    static int n;
    static int arr[];
    static int tmp[];
    static long result = 0;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        tmp = new int[n];
        arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        mergeSort(arr, tmp, 0, n-1);

        System.out.println(result/2);

    }

    private static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;
            mergeSort(arr, tmp, left, m);
            mergeSort(arr, tmp, m + 1, right);
            merge(arr, tmp, left, m, right);
        }
    }

    private static void merge(int[] arr, int[] tmp, int s, int m, int e) {
        for (int i = s; i <= e; i++) {
            tmp[i] = arr[i];
        }
        int part1 = s;
        int part2 = m + 1;
        int index = s;
        while (part1 <= m && part2 <= e) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                result += Math.abs(part1 - index);
                part1++;
            } else {
                arr[index] = tmp[part2];
                result += Math.abs(part2 - index);
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= m - part1; i++) {
            result += Math.abs(index - part1);
            arr[index + i] = tmp[part1 + i];
        }
    }
}