package 알고리즘_코딩테스트.dayone.apr18;
import java.util.*;

public class boj1110 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int original = n;
        int count = 0;

        do {
            int tens = n / 10;
            int ones = n % 10;
            int sum = tens + ones;
            n = (ones * 10) + (sum % 10);
            count++;
        } while(n != original);

        System.out.println(count);
    }
}
