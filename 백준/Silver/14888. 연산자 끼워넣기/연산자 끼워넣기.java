
import java.util.*;
import java.io.*;

/*
2
5 6
0 0 1 0

30
30

----------
3
3 4 5
1 0 1 0

35
17
 */
/*
최댓값을 구할 경우
- 다음 /
+ 다음 x

최솟값을 구할 경우
+ 다음 %
- 다음 x
-----------

 */
public class Main {
    static int n;
    static int[] arr;
    static long max = Integer.MIN_VALUE;
    static long min = Integer.MAX_VALUE;
    static int[] op = new int[4]; //덧셈, 뺄셈, 곱셈, 나눗셈
    public static void main(String[] args) throws IOException{

        input();
        solve();
    }

    private static void solve(){

        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int idx){//num은
        if (idx == n){
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }

        for(int i = 0 ; i < 4; i++){//연산자의 개수는 n-1개
            //연산자 사용
            if (op[i] > 0){
                op[i]--;

                int check = i;
                switch (check){
                    case 0:{
                        dfs(num + arr[idx], idx+1);
                        break;
                    }
                    case 1:{
                        dfs(num - arr[idx], idx+1);
                        break;
                    }
                    case 2:{
                        dfs(num * arr[idx], idx+1);
                        break;
                    }
                    case 3:{
                        dfs(num / arr[idx], idx+1);
                        break;
                    }
                }
                //연산자 다시 복귀
                op[i]++;
            }

        }

    }

    private static void input()throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0 ;  i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < 4 ; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

    }
}
