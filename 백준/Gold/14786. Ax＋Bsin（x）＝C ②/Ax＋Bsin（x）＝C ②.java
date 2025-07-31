import java.io.*;
import java.util.*;

public class Main {
    static int a, b, c;
    public static void main(String args[]) throws IOException {
        input();
        solve();
    }
    private static void solve(){
        double left = 0;
        double right = 1e9;

        for(int i =0  ; i< 100 ;i++){
            double mid = (left+right)/2;

            double fff = a * mid + b * Math.sin(mid);
            if (fff < c) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.printf("%.15f\n", (left + right) / 2);
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }
}
