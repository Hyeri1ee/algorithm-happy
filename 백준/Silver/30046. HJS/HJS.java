
import java.io.*;
import java.util.*;

public class Main {
    static String P, Q, R;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = br.readLine();
        Q = br.readLine();
        R = br.readLine();

        for (int h = 1; h <= 9; h++) {
            for (int j = 1; j <= 9; j++) {
                if (j == h) continue;
                for (int s = 1; s <= 9; s++) {
                    if (s == h || s == j) continue;
                    //서로 다른 h, j, s를 선택
                    
                    int[] map = new int[256];
                    map['H'] = h;
                    map['J'] = j;
                    map['S'] = s;

                    if (check(map)) {//쌩비교
                        System.out.println("HJS! HJS! HJS!");
                        
                        return;
                    }
                }
            }
        }
        System.out.println("Hmm...");
    }

    static boolean check(int[] map) {
        return less(P, Q, map) && less(Q, R, map);
    }

    static boolean less(String a, String b, int[] map) {
        for (int i = 0; i < N; i++) {
            int x = map[a.charAt(i)];
            int y = map[b.charAt(i)];
            if (x != y) return x < y;
        }
        return false;
    }
}
