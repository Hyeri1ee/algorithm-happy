package 알고리즘_코딩테스트.dayone.mar05;

import java.io.*;
import java.util.*;

/**
 * 55-(50+40) = -35
 */
public class BOJ_1541 {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static String[] op;

    public static void main(String[] args)throws IOException {
        //입력받고, - 기준으로 다음 - 가 나올때까지 더하기, 나머지 부분은 +로 연산
        op = bf.readLine().split("-");
        int i = 0;
        int result = 0;

        //+ 끼리 먼저 계산
        for (String num : op){
            String[] arr = num.split("\\+");
            int numsum = Arrays.stream(arr)
                    .mapToInt(Integer::parseInt)
                    .sum();
            if (i == 0)
                result += numsum;
            else
                result -= numsum;
            i++;
        }

        System.out.println(result);



    }
}
