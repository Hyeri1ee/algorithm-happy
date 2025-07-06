package 알고리즘_코딩테스트.dayone.may2;

import java.io.*;
import java.util.*;

public class boj12789 {
    static int n;
    static Queue<Integer> arr = new LinkedList<>();//오른쪽
    static Stack<Integer> stacks = new Stack<>();//아래

    static boolean result = false;

    public static void main(String[] args) throws Exception{
        input();
        solve();
    }

    private static void solve(){
        int num = 0;//num번째까지가 간식을 받음

        while(true){
            int check = 0;//아래, 오른쪽 모두 해당되는 게 없음

            if (stacks.isEmpty())
                if (arr.isEmpty())
                    break;
                else
                    stacks.push(arr.poll());

            //아래 확인
            if (!stacks.isEmpty()){
                if (num+1 == stacks.peek()){
                    stacks.pop();//처리
                    num++;
                }else{//일치하지 않는 경우
                    //오른쪽 확인
                    if (!arr.isEmpty()){
                        if (num+1 == arr.peek()){
                            stacks.push(arr.poll());
                        }else{
                            stacks.push(arr.poll());
                        }
                    }else{//오른쪽이 빈 경우
                        if (!stacks.isEmpty()){
                            if (num+1 != stacks.peek())
                                break;
                        }
                    }
                }
            }


        }//end of while

        if (num == n)
            result= true;

        System.out.println(result ? "Nice" : "Sad");

    }

    private static void input()throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n  = stoi(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i < n ; i++){
            arr.offer(stoi(st.nextToken()));
        }

    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }

}
/*
테스트 케이스
T:1

6
1 4 3 2 5 6

 */