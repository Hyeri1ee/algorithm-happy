
import java.io.*;
import java.util.*;

/**
 9 3
 1 2 3 4 5 6 7 8 9
 */
public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        int maxsum, minsum = 0;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > minsum)
                minsum = arr[i];
        }

        // 레슨 시간 이진탐색 범위 구하기
        maxsum = Arrays.stream(arr).sum();

        int low = minsum;
        int high = maxsum;

        while(low <= high){
            int mid = (high + low) / 2; //블루레이 크기 후보
            int sum = 0; //레슨합
            int count = 0; //필요한 블루레이 개수
            for (int i = 0 ; i < n; i++){
                if (sum + arr[i] > mid){
                    count++;//하나의 블루레이 추가
                    sum = 0;
                }
                sum = sum + arr[i];
            }
            if (sum != 0){
                count++;
            }
            if (count <= m){ //가능한 블루레이 개수인지
                high = mid-1;
            }else{//count > m
                low = mid+1;
            }
        }

        System.out.println(low);
    }
}
