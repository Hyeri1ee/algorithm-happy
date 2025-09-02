
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int d;

    public static void main(String[] args) throws Exception{
        input();
        solve();

    }

    private static void solve(){
        int count = 0;
        char target = (char) (d+'0');

        for(int i = 1; i <= n;i++){
            String s = String.valueOf(i);
            for(char c : s.toCharArray()){
                if (c == target)
                    count++;
            }
        }

        System.out.println(count);
    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
    }
}
