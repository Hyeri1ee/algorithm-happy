
import java.util.Scanner;

public class Main {
    //n번째로 구하고자하는 피보나치 수 = P_(n) = P_(n-1) + P(n-2)
    static Scanner sc = new Scanner(System.in);
    static int n;

    public static void main(String[] args){
        n = sc.nextInt();
        int i = 1;
        long p1 = 0;
        long p2 = 1;

        while(i <= n){
            long temp = p2;
            p2 = p1 + p2;
            p1 = temp;
            i++;

        }

        System.out.println(p1);
    }
}
