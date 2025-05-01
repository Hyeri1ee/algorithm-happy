import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 자료구조 개수

        int[] typeArr = new int[N]; // 자료구조 배열

        StringTokenizer st = new StringTokenizer(br.readLine());

        //각각 자료구조의 개수만큼 어떠한 자료구조를 가지는지 입력받기(큐 or 스택)
        for(int i = 0; i < N; i++){
            // 일단 자료구조형태값만 받는다.
            typeArr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        //각각의 자료구조가 가지는 값 입력받기(하나의 원소밖에 가지지 못함)
        for(int i = 0; i < N; i++){
            //스택은 들어가자마자 나오기 때문에 자료형이 큐인 것만 저장한다.
            int num = Integer.parseInt(st.nextToken());
            if(typeArr[i] == 0){
                deque.addLast(num);
            }
        }

        int M = Integer.parseInt(br.readLine()); // 삽입할 수열의 길이

        st = new StringTokenizer(br.readLine());
        br.close();
        // 수열을 삽입한다.
        while(M --> 0){
            int moveValue = Integer.parseInt(st.nextToken());
            // 만약 큐만 없고 스택으로 이루어졌다고 해도 바로 빼기 때문에 (pollLast()) 문제가 되지 않는다.
            // => 첫번째에 넣고 마지막을 뺀다. (큐의 자료구조를 가진 큰 큐로 가정해서 풀면 되는 문제)
            deque.addFirst(moveValue);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
        