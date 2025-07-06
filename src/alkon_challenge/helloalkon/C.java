package alkon_challenge.helloalkon;

import java.util.*;

//3

/*
3 2 1
3 2 / / 1
3 / 2 1 /
/ 2 1 / 3

 */

public class C {
    static long result = 0;
    static int n;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        n = sc.nextInt();

    /*    result += n-1;//1번에 있는 맨 아래 원판 빼고 다 2번으로 옮김
        result += 1; //맨 아래 원판 3번으로 옮김
        result += n-2;
        result+= 1;*/
        /*
        n = 3

        +2
        +1
        +1
        +1
        +0
        +1
         */
        while(n-- >0){
            result += n;
            result += 1;
        }



        System.out.println(result);

    }

}
