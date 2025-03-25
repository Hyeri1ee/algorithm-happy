
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();

        System.out.println(pibo(n));

    }

    public static long pibo(long n){
        if (n == 1 || n == 0)
            return n;
        else
            return pibo(n-1) + pibo(n-2);
    }
}
