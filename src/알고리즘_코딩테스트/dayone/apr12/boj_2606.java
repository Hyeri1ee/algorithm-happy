package 알고리즘_코딩테스트.dayone.apr12;
import java.io.*;
import java.util.*;

public class boj_2606 {
    static int n;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        input();
        //solve();
    }

    private static void input() throws Exception{
        n = stoi(bf);

    }

    private static int stoi(BufferedReader bf) throws Exception{
        return Integer.parseInt(bf.readLine());
    }
}
