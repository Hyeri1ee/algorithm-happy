
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<int[]> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve(){
        for(int i = 0 ; i < list.size(); i++){
            int min = Math.min(list.get(i)[0], list.get(i)[1]);
            min = Math.min(min, list.get(i)[2]);
            sb.append(min +"\n");
        }

        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < n ; i++){
            String[] s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b =  Integer.parseInt(s[1]);
            int c =  Integer.parseInt(s[2]);
            list.add(new int [] {a, b,c});
        }

    }
}
