import java.io.*;
import java.util.*;

public class Main{
    static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int pre = n / 5;
        int left = n%5;
        if (left != 0)
            System.out.println(pre+1);
        else
            System.out.println(pre);
    }
}