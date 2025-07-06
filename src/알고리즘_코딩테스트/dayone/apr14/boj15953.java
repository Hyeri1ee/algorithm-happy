package 알고리즘_코딩테스트.dayone.apr14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15953 {
    static int[]first_person = {1,3,6,10,15,21};
    static int[]second_person = {1,3,7,15,31};

    static int[] first_prize = {500,300,200,50,30,10};
    static int[] second_prize ={512,256,128,64,32};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception{
        int T;
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for(int test_case = 0 ; test_case<T;test_case++){
            //sb.append(challenge(bf));
        }
    }

/*    private static int challenge(BufferedReader bf) throws Exception{
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int result = 0;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i <first_person.length; i++){
            if (first_person[i] > a)
            {
                result += first_person[i-1];
            }
        }
    }*/
}
