
/*
입력

PPPAPAP

출력

PPAP

입력

PPAPAPP

출력

NP
 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
    static char[] str;

    public static void main(String[] args) throws IOException {
        str = bf.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        // PP -> A 이면 pop 2번
        for (int i = 0 ; i < str.length ; i++){
            if (str[i] == 'P'){
                stack.push(str[i]);
            }else if (str[i] == 'A' && stack.size() >= 2 && i<str.length-1 && str[i+1] == 'P'){
                stack.pop();
                stack.pop();
            }
            else{
                System.out.println("NP");
                return;
            }
        }

        if (stack.size() == 1){
            System.out.println("PPAP");
        }else{
            System.out.println("NP");
        }
        return;
    }
}
