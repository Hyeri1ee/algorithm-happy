
import java.util.Arrays;
import java.util.Scanner;
/*
queen 은 knight가 공격하는 방향으로 놓아야함.
각 원소의 열 = 1차원 배열의 인덱스
각 원소 값 = 퀸이 놓인 위치
 */
public class Main {
    static int n;
    static int ans = 0;
    static int[] maps;//i행에 놓은 퀸 열의 위치

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maps = new int[n];

        solve(0);
        System.out.println(ans);
    }
    private static void solve(int q){
        if (q == n)
        {
            ans++;
            return;
        }


        for(int a = 0 ; a < n ; a++){
            if (isright(q, a)){
                maps[q] = a;
                solve(q + 1);
            }
        }

    }

    private static boolean isright(int q, int a){
        for(int i = 0 ; i < q; i++){
            //같은 열에 잇는지
            if(maps[i] == a)
                return false;

            //대각선 체크
            if (Math.abs(q-i) == Math.abs(maps[i]-a))
                return false;
        }
        return true;
    }

}
