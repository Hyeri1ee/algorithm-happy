import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        int i = 1;
        int result = 0;
        while(n-- > 0){
            sb.append(i+"\n");
            i++;
        }
        System.out.println(sb);
    }
}