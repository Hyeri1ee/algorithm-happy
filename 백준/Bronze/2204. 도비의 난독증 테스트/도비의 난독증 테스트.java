import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[] arr;
    static Scanner sc = new Scanner(System.in);;

    static boolean keepgoing = true;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        while(keepgoing){
            input();
            if (keepgoing)
                solve();
        }

        System.out.println(sb);

    }
    private static void solve() {
        int minIndex = 0;

        for (int i = 1; i < n; i++) {
            //대소문자 무시 . 사전순 비교
            if (arr[i].compareToIgnoreCase(arr[minIndex]) < 0) {
                minIndex = i;
            }
        }

        sb.append(arr[minIndex]).append("\n");
    }
    private static void input(){

        n = sc.nextInt();
        if (n == 0)
        {
            keepgoing = false;
            return;
        }

        arr = new String[n];

        for(int i = 0 ; i < n; i++){
            arr[i] = sc.next();
        }


    }
}
