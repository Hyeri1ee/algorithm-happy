
import java.util.*;

/*
N의 분해합 = N + N을 이루는 각 자리수 = M(N의 생성자)

 */
public class Main {
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        //자릿수
        String s = String.valueOf(n);
        int init = n;

        for(int i = 0 ; i < s.length(); i++){

            init -= 9;

        }
        if (init < 0) init  = 0;


        for(int i = init; i < n; i++){
            int cand = i;
            int plus = cand;
            int temp = cand;

            while( temp > 0){
                plus += temp % 10;
                temp /= 10;
            }

            if (plus == n)
            {
                System.out.println(cand);
                return;
            }
        }

        System.out.println(0);


    }
}
