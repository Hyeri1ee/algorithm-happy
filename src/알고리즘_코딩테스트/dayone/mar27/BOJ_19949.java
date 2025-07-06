package 알고리즘_코딩테스트.dayone.mar27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_19949 {
    /*
    1 2 3 4 5 1 2 3 4 5


    261622


     */
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int[] score;
    static int[] choose;
    static  int answer = 0;


    public static void main(String[] args) throws IOException {
        score = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        choose = new int[10];

        dfs(0);

        System.out.println(answer);

    }

    private static void dfs(int depth){

        if(depth==10) {
            int sum=0;
            for(int i=0;i<10;i++) {
                if(score[i]==choose[i])
                    sum++;
            }
            // 5점이 넘었다면 경우의 수 count
            if(sum>=5)
                answer++;

            return;
        }

        for(int i=1;i<6;i++) {
            if(depth>1&&choose[depth-1]==i&&choose[depth-2]==i)//이전 두 문제에 쓴 답과 같으면 안됨
                continue;

            choose[depth]=i; //5지선다형 중 하나 선택
            dfs(depth+1); //재귀호출
            choose[depth]=0; //초기화
        }
    }
}
