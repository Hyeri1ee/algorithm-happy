
import java.io.*;
import java.util.*;

/*
a,b,c 중
하나라도 0이하이면 1
하나라도 20 초과이면 w(20,20,20)
a < b < c 이면
 */
/*
TOP DOWN
DP[N] = DP[N-1](1을 뒤에 붙이기) + DP[N-2](00을 뒤에 붙이기)
DP[1] = 1
DP[2] = 2

 */
public class Main {
    static int n;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        arr = new long[n+1];
        if (n == 1){//예외처리
            System.out.println(1);
            return;
        }else if (n == 2){
            System.out.println(2);
            return;
        }
        arr[1] = 1;
        arr[2] = 2;
        int i = 3;
        while(i <= n){
            arr[i] = ((arr[i-1] % 15746) + (arr[i-2] % 15746)) % 15746;
            i++;
        }

        System.out.println(arr[n]);
        sc.close();
    }
}
