

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
           st = new StringTokenizer(bf.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());

           //가장 긴변을 c로 위치하도록
            if (b >a && b > c)//b가 큰 경우
            {
                int temp = c;
                c = b;
                b = temp;
            }else if (a > b && a > c){//a가 큰 경우
                int temp = a ;
                a = c;
                c = temp;
            }

           if (a == 0 && b == 0 && c == 0) break;

           switch(check(a,b,c)){
               case 0:{
                   sb.append("Equilateral"+"\n");
                   break;
               }
               case 1:{
                   sb.append("Scalene"+"\n");
                   break;
               }
               case 2:{
                   sb.append("Invalid"+"\n");
                   break;
               }
               case 3:{
                   sb.append("Isosceles"+"\n");
                   break;
               }
           }

       }

        System.out.println(sb);
    }

    private static int check(int a, int b, int c){
        //삼각형이 아닌지 판단
        if (c >= a+b) return 2;

        //삼각형인 경우

        //정삼
        if (a == b && b == c) return 0;
        //이등변
        if (a==b || a==c || b == c) return 3;

        return 1;


    }
}
