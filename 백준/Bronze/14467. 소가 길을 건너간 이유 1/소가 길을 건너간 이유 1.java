// 머리아플때 구현 풀기 (1/3)

import java.io.*;
import java.util.*;

public class Main {
    static class sowhich {
        int num;
        int which;
        public sowhich(int n, int w){
            this.num = n;
            this.which = w;
        }
    }
    static int n;
    static int[] arr;
    static sowhich[] origin;

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+1]; //소 바뀐 최근 위치 저장
        Arrays.fill(arr, -1);
        //origin = new sowhich[n+1];

        for(int i = 1; i <= n ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //origin[i] = new sowhich(a, b);
            if (arr[a] == -1){//초기화
                arr[a] = b;
                continue;
            }
            if (arr[a] != b)//변경
            {arr[a] = b;
                ans++;}
        }

        System.out.println(ans);
    }
}
