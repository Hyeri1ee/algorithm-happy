import java.util.*;
import java.io.*;

/*
반례1:
2
1 2
0 //정답: 2

1
1
1

반례2:
i:   0  1  2  3
val: 1  2  3  2  1
ans:  +1 +1 -1 -1
정답 : 3 //내 코드 4 로 오답



 */
public class Main {
    static int M;
    static long[] arr;
    static int[] answer;//

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() throws IOException {
        //예외처리
        if (M == 1){
            System.out.println(1);
            return;
        }


        //증감 answer에 표시
        for(int i = 1 ; i < M; i++){
            updown(i);
        }

        //1이 이어진 최대 길이 계산
        int len_positive = 0;
        int len = 0;
        //-1이 이어진 최대 길이 계산
        int len_negative = 0;
        int len2 = 0;

        for(int i = 0 ; i < M-1; i++){

            if (answer[i] == 1){
                len++;

                if(len_negative < len2)
                    len_negative = len2;
                len2 = 0;//초기화
            }

            if (answer[i] == -1){
                len2++;

                if(len_positive < len)
                    len_positive = len;
                len = 0;//초기화
            }

            //마지막
            if (len2 > 0|| len > 0){
                if (len_negative < len2)
                    len_negative = len2;

                if (len_positive < len)
                    len_positive = len;
            }

        }


        System.out.println(check(len_positive, len_negative));
    }
    private static String check(int len_positive, int len_negative){
        if (len_positive == len_negative){
            return String.valueOf(len_positive+1);
        }else{
            return (len_positive > len_negative) ? (len_positive+1) +"" : (len_negative+1) +"";
        }
    }

    private static void updown(int i) {
        if (arr[i -1] > arr[i]){
            answer[i-1] = -1;
        }else if (arr[i -1] < arr[i]){
            answer[i-1] = 1;
        }else
            answer[i-1] = 0;
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(bf.readLine());

        arr = Arrays.stream(bf.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        answer = new int[M-1];

    }
}
