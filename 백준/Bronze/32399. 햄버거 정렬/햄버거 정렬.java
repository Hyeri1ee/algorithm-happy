
import java.io.*;
import java.util.*;

public class Main {
    static char[] rr;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        rr = bf.readLine().toCharArray();

        switch(rr[0]){
            case '(':{
                if (rr[1] == '1'){
                    break;
                }
                if (rr[1] == ')'){
                    count++;
                    break;
                }
            }
            case '1':{
                if (rr[1] == ')'){
                    count++;
                    break;
                }
                if (rr[1] == '('){
                    count++;
                    break;
                }
            }
            case ')':{
                if (rr[1] == '1'){
                    count+= 2;
                    break;
                }
                if (rr[1] == '('){
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);


    }
}
