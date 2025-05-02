
import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static Stack<Integer> arr = new Stack<>();
    public static void main(String[] args) throws Exception{
        input();
        int result = 0 ;
        while(!arr.isEmpty()){
            result += arr.pop();
        }
        System.out.println(result);
    }
    private static void input()throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        k = stoi(bf.readLine());

        for(int i = 0 ; i < k ; i++){
            int num = stoi(bf.readLine());
            if (num == 0)
                arr.pop();
            else
                arr.push(num);
        }

    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
