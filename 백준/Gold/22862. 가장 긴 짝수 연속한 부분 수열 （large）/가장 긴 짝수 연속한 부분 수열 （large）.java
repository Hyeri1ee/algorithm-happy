
import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static ArrayList<Integer> num = new ArrayList<>();
    static ArrayList<Boolean> visit = new ArrayList<>();

    public static void main(String[] args) {
        /*
        수열 S : 1 2 3 4 5 6 7 8
                //0 1 1 2 2 3 3 4 =>짝수의 개수의 총합
                k개 원소를 삭제했을 때 1 2 3 .. 이렇게 단순 증가하면 연속함.

                F T F T T F F T
                1 4 3 2 2 5 5 6

         */
        Scanner sc = new Scanner(System.in);
        String[] parts = sc.nextLine().split(" ");
        n = Integer.parseInt(parts[0]);
        k = Integer.parseInt(parts[1]);

        parts = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(parts[i]);
            if (a % 2 == 0)
                visit.add(true);
            else
                visit.add(false);
            num.add(a);
        }

        //

        int start = 0; int end =0 ;
        int oddcount =0;
        int maxLen = 0;
        while(end < n){
            if (num.get(end) % 2 != 0) oddcount++;
            end++;

            while(oddcount > k){
                if (num.get(start) % 2   != 0) oddcount--;
                start++;
            }

            maxLen = Math.max(maxLen, end -  start - oddcount);
        }

        System.out.println(maxLen);
    }
}
