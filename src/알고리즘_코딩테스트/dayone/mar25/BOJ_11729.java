package 알고리즘_코딩테스트.dayone.mar25;

import java.util.*;

/*
입력

3

출력

7
1 3
1 2
3 2
1 3
2 1
2 3
1 3
*/

/*
N-1개의 원판을 1 에서 2로 옮기고,
가장 아래 원판을 1 에서 3으로 옮기고,
N-1개의 원판을 다시 2 -> 3으로 옮김
 */

public class BOJ_11729 {
    static int n;
    static int k;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        /*
        n개의 원판을 1->2->3
            n-1개의 원판을 1->3->2
                n-2개의 원판을 1->2->3
                    가장 아래 원판을 1->2
                n-2개의 원판을 3->1->2
         가장 아래 원판을 1->3
         n-1개 원판을 2->1->3
         */
        //1->2->3
        hano(n,1,2,3);
        System.out.println(k);
        System.out.println(sb);
    }
    //a:출발 장대, b:거칠장대, c:도착할장대
    public static void hano(int n,int a, int b, int c){
        k++;
        if(n==1){
            sb.append(a +" " + c +"\n");
            return;
        }
        //1->3->2
        hano(n-1, a,c,b);
        sb.append(a +" " + c +"\n");//가장 아래 원판 1->3
        //2->1->3
        hano(n-1, b,a,c);

    }
}
