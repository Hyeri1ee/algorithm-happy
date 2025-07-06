package 알고리즘_코딩테스트.dayone.apr04;
/*
삼성sw역량테스트

주의
answer(최소 감독수 결과값) 최악의 경우 int범위(2_147_483_648)를 넘어갈 수 있음
 */
import java.io.*;
import java.util.*;

public class boj_13458 {
    static int n;//시험장의 개수
    static long[] arr;//각 시험장 마다 응시자 수
    static long[] gamdok = new long[2];//총감독관 , 부감독관이 한 시험장에서 감시할 수 있는 응시자 수
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args)throws IOException {
        input();
        solve();
        /*
        조건1: 총감독관은 없어도 되고 있으면 최대 1명
         */
    }

    private static void solve(){
        long answer = 0;

        //구현
        answer += n;//주의 : gamdok[0]이 아님!!

        for(int i = 1; i < n+1; i++){

            arr[i] -= gamdok[0];//총감독관 쓰기

            if (arr[i] <= 0) continue; //끝!
            answer += arr[i] / gamdok[1];//부감독관 쓰기
            if (arr[i] % gamdok[1] != 0){//남은거
                answer++;
            }
        }


        System.out.println(answer);
    }

    private static void input()throws IOException{
        n = Integer.parseInt(bf.readLine());
        arr = new long[n+1];


        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 1 ; i < n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //총 감독관, 부 감독관
        st = new StringTokenizer(bf.readLine());
        gamdok[0] = Long.parseLong(st.nextToken());
        gamdok[1] = Long.parseLong(st.nextToken());
    }
}
