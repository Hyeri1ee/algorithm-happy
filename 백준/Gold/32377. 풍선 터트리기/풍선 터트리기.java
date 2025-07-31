
import java.io.*;
import java.util.*;

public class Main {
    static int N, x, y, z;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void solve(){
        long max = Math.max(arr[0], Math.max(arr[1], arr[2]));


        //걸리는 시간을 이진탐색
        long left= 1;
        long right = max * N;

        while(left <= right){
            long mid =  (left + right)/2;

            //mid초까지 count 개 물건 옮길 수 있음
            long count = 0;
            for(int i = 0 ; i< 3; i++){
                count += (mid /arr[i]);
            }

            if (count >= N){
                right = mid-1;
            }else{
                left = mid + 1;
            }
        }

        long countRE = 0;
        for(int i = 0 ; i < 3; i ++){
            countRE += ((left - 1)/arr[i]);//left-1시간 전에 i 번째 사람이 몇 개를 끝내놧냐

        }

        //left 초
        for(int i = 0 ; i < 3; i ++){
            if (left % arr[i] == 0){
                countRE++;

                if (countRE == N){//마지막
                    if (i == 0) {
                        System.out.println("A win");
                    } else if (i == 1) {
                        System.out.println("B win");
                    } else {
                        System.out.println("C win");
                    }
                    break;
                }
            }
        }

    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new long[3];

        for(int i = 0 ; i < 3 ; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

    }
}
