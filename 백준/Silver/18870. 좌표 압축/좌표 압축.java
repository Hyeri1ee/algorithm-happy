

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<int[]> arr = new ArrayList<>();
    static int[] result;
    static int[] copyArr;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        result = new int[n];

        st = new StringTokenizer(bf.readLine());

        for(int i = 0 ; i < n ;i++){
            int a = Integer.parseInt(st.nextToken());

            arr.add(new int[] {i, a});
        }

        arr.sort(Comparator.comparingInt(a -> a[1]));//arr 원소의 각각 두번째 원소를 기준으로

        int rank = 0;
        for(int i = 0 ; i< n ; i++){
            int[] t = arr.get(i);
            int index = t[0];
            int value = t[1];

            if (i == 0 || value != arr.get(i-1)[1]) {
                rank++;
            }

            result[index]  = rank - 1;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(result[i]).append(" ");
        System.out.println(sb);
    }
}
