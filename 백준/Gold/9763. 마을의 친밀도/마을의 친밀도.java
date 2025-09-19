
import java.io.*;
import java.util.*;

public class Main {
    /*
    10000에서 3 택 = 10000 x 9999 x 9998 / 6
    각각의 점으로부터 가장 가까운 점 2개 뽑아서 마을의 친밀도 구해놓고
        min 값 갱신하기
     */
    static int n;
    static class maeul{
        int x, y, z;
        public maeul(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static maeul[] arr;
    static int min1 = Integer.MAX_VALUE;
    public static void main(String[] args)throws Exception{
        input();

        for(int i = 1; i <= n; i++){
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            for(int j = 1; j <= n; j++){
                if (i == j ) continue;

                int xdff = Math.abs(arr[i].x - arr[j].x);
                int ydff = Math.abs(arr[i].y - arr[j].y);
                int zdff = Math.abs(arr[i].z - arr[j].z);
                int dist = xdff + ydff + zdff;

                if (dist < first) {
                    second = first;
                    first = dist;
                } else if (dist < second) {
                    second = dist;
                }

            }

            min1 = Math.min(min1, first+second);


        }//end of for

        System.out.println(min1);


    }
    private static void input()throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new maeul[n+1];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            arr[i+1] = new maeul(x, y , z);
        }
    }
}
