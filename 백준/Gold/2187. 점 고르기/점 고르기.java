
import java.util.*;
import java.io.*;

class loca{
    int x, y, value;
    public loca(int x, int y, int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
public class Main {
    /*
8 4 2
1 4 9
1 5 8
2 10 2
3 2 6
4 6 1
5 15 3
6 4 5
7 9 4
     */
    static int n,a,b;
    static List<loca> maps;

    public static void main(String[] args){
        input();
        solve();
    }
    private static void solve(){
        int ans = 0;

        for (int i = 0; i < n; i++) {
            loca p = maps.get(i);
            for (int j = 0; j < n; j++) {
                loca q = maps.get(j);
                int dx = Math.abs(p.x - q.x);
                int dy = Math.abs(p.y - q.y);
                if (dx < a && dy < b) {
                    ans = Math.max(ans, Math.abs(p.value - q.value));
                }
            }
        }

        System.out.println(ans);
    }
    

    private static void input(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //점 개수
        a = sc.nextInt(); //가로
        b = sc.nextInt(); //세로

        maps = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int value = sc.nextInt();
            maps.add(new loca(x, y, value));
        }

    }

}
