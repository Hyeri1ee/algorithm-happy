
import java.io.*;
import java.util.*;

public class Main {
    /*
    arr[1000000]
    m이 짝수인 경우 arr에 들어간 최종 수가 짝수개여야 하고
    m이 홀수인 경우 arr에 들어간 최종수가 n개 만큼만 홀수개여야 함
     */
    static int n, m;
    static int[][] map;
    static int[] arr;
    static Set<Integer> seen = new HashSet<>();

    public static void main(String[] args) throws Exception{
        input();

        int nOdd = 0;
        if (m  % 2 == 0){
            for(int i : seen){
                if (arr[i] % 2 == 1)
                {
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }else{//m홀수
            for(int i : seen){
                if (arr[i] % 2 == 1)
                {
                    nOdd++;
                }
            }


            //print
            if (nOdd <= n){
                System.out.println("YES");
                return;
            }

            System.out.println("NO");

        }




    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        arr =  new int[1000001];
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            map[i] = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int in : map[i]){
                arr[in] += 1;
                seen.add(in);
            }
        }
    }
}
