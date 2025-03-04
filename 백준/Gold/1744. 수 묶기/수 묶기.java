
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static int n;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //n값 입력받기
        n = Integer.parseInt(bf.readLine());

        //n개의 정수 입력 받기
        //우선순위큐에 넣기
        PriorityQueue<Integer> positives = new PriorityQueue<>(Collections.reverseOrder()); //양수: 내림차순
        PriorityQueue<Integer> negatives = new PriorityQueue<>(); //0과 음수: 오름차순 (점점 숫자가 커짐, 절댓값은 작아짐) -5 -3 -2 -1 0

        for (int i = 0 ; i < n; i++){
            int number = Integer.parseInt(bf.readLine());
            if (number > 0){
                positives.offer(number);
            }else {
                negatives.offer(number);
            }
        }

        //가장 큰 두 수끼리 묶어 sum 값에 더하기
    /*
        음수, 양수는 묶으면 최대값이 안나옴!

        음수는 0이 없으면 무조건 더하기
        음수는 0이 있으면 0과 곱하기
        양수는 <두 수를 모두 더한 것> <두 수를 모두 곱한 것> 둘 중 큰 값 나오는거로 택1
     */
        int total = 0;

        //양수
        while(!positives.isEmpty()){
            int one = positives.poll();
            if (!positives.isEmpty()){
                int two = positives.poll();

                int mul = one * two;
                int sum = one + two;

                total += Math.max(mul, sum);
            }else{ //마지막 한 원소만 남은 경우
                total += one;
            }
        }

        //음수
        while(!negatives.isEmpty()){
            int one = negatives.poll();
            if (!negatives.isEmpty()){
                int two = negatives.poll();

                int sum = one * two;
                total += sum;
            }else{ //마지막 한 원소만 남은 경우
                total += one;
            }
        }

        System.out.println(total);


    }


}
