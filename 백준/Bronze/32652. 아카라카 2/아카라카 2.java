
import java.io.*;
import java.util.*;

/*
AKA R AKA 1

AKA R AKA R AKA 2

AKA R AKA R AKA R AKA 3 => R의 개수에 따라 결정됨
 */

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder sb =new StringBuilder();
        sb.append("AKA");

        while(n-- >0){
            sb.append("RAKA");
        }

        System.out.println(sb);


    }
}
