package codingtest.StackQueue;

import java.util.*;
import java.io.*;
/*
계산
큰 수가 들어가면 모두 pop.
pop한 개수를 answer에 넣기
[93 30 55]
[1 30 5]
[7 3 9]

[95 90 99 99 80 99]
[1 1 1 1 1 1]
[5 10 1 1 20 1]

=> [1 3 2
*/
class Solution2 {

    public int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stacks = new Stack<>();
        ArrayList<Integer> answer = new ArrayList<>();//배포 개수 반환
        int[] left = new int[progresses.length];//작업이 끝날때까지 남은 일수

        //계산
        calculate(progresses, speeds, left);
        //left 배열 -> 큰 수가 들어가면 모두 pop
        stacks.push(left[0]);

        int count = 1;
        for(int i = 1; i < left.length; i++){
            int current = left[i];

            if (current <= stacks.peek()){
                count++;
            }else{
                answer.add(count);
                stacks.clear();
                stacks.push(current);
                count = 1;
            }
        }

        //마지막 남은 작업 정리
        if (!stacks.isEmpty()) {
            answer.add(count);
        }

        //pop한 개수를 answer에 넣기
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    void calculate(int[] progresses, int[] speeds, int[] left){
        for(int i = 0 ; i < progresses.length; i++){
            int leftwork = 100 - progresses[i];

            left[i] = (leftwork % speeds[i] == 0)
                    ? (leftwork / speeds[i])
                    : (leftwork / speeds[i]) + 1;
        }
    }
}
public class 기능개발 {
    static int[] progresses, speeds;
    public static void main(String[] args) throws IOException{
        input();
        solve();
    }
    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        progresses = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        speeds = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
    static void solve(){
        int[] answer = new Solution2().solution(progresses, speeds);
        System.out.println("결과: " + Arrays.toString(answer));    }
}
