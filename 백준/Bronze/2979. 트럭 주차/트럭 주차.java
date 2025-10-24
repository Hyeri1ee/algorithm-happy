
import java.io.*;
import java.util.*;

public class Main {
    static int a, b, c;
    static int[] check;
    static int max = 0;
    static int ans = 0 ;

    static int[][] in = new int[3][2];

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();

        solve();

        System.out.println(ans);

    }
    private static void solve(){
        for(int i = 0 ; i < 3;i++){
            int[] target = in[i];
            int start  = target[0];
            int end = target[1];
            for(int j = start; j < end; j++){
                check[j] +=1;
            }
        }


        for(int i = 1; i < max+1; i++){
            plus(check[i]);
        }
    }

    private static void plus(int t){
        switch (t){
            case 1:{
                ans += t * a;
                break;
            }
            case 2:{
                ans += t * b;
                break;
            }
            case 3:{
                ans += t * c;
                break;
            }
        }
    }
    private static void input() throws Exception{
        st = new StringTokenizer(bf.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < 3; i++){
            st =new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            max = Integer.max(max, e);
            in[i] = new int[] {s,e};
        }

        check = new int[max+1];
    }
}
