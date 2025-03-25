
import java.io.*;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        long n = sc.nextInt();
        System.out.println(factorial(n));
    }

    public static long factorial(long n){
        if (n == 1 || n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }
}
