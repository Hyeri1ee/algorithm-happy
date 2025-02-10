package 알고리즘_코딩테스트.dayone.feb10;


import java.io.*;
import java.util.*;

public class BOJ_11004 {

  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int[] arr;

  public static void main(String[]args) throws IOException {
    int n, k;
    String input = bf.readLine();
    StringTokenizer st = new StringTokenizer(input);
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new int[n];

    st = new StringTokenizer(bf.readLine());
    for (int i = 0 ; i < n ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Integer[] boxedArray = Arrays.stream(arr)
            .boxed()
            .toArray(Integer[]::new);
    Arrays.sort(boxedArray);

//    quicksort(0, n-1);

    System.out.println(boxedArray[k-1]);

  }
  private static void quicksort(int start, int end) {//start,end는 인덱스
    if (start >= end) return;

    int pivot = partition(start, end);

    quicksort(start, pivot - 1);
    quicksort(pivot + 1, end);
  }

  private static int partition(int start, int end) {
    int pivot = arr[end-start];
    int left = start;
    int right = end;

    while (left <= right) {
      while (left <= end && arr[left] <= pivot) left++;
      while (right > start && arr[right] > pivot) right--;

      if (left <= right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
      }
    }//end of while

    // 피벗과 right 위치 교환
    int temp = pivot;
    arr[end-start] = arr[right];
    arr[right] = temp;

    return right;
  }

}
