package alkon_challenge.week1;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class two {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws  IOException{
        int[] arr = {500, 100, 50, 10, 5 , 1};
        int count = 0 ;

        int here = Integer.parseInt(bf.readLine());
        int giveme = 1000 - here;

        for (int i =0 ; i < arr.length ; i++){
            count += giveme / arr[i];
            giveme = giveme % arr[i];
        }

        System.out.println(count);




    }
    //낸 돈 입력

    //1000 - 낸돈

    //500 100 50 10 5 1 로 그리디
}
