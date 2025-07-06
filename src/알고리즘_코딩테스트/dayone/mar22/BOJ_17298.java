package 알고리즘_코딩테스트.dayone.mar22;

import java.io.*;
import java.util.*;
/*
4
3 5 2 7

5 7 7 -1
 */

public class BOJ_17298 {
    static int n;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        int[] arr = Arrays.stream(bf.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] answer = new int[n];
        Arrays.fill(answer,-1);

        Stack<Integer> stack = new Stack<>(); //오큰수의 인덱스들

        for (int i = 0; i < n; i++) {
            // 현재 숫자(arr[i])가 stack의 top이 가리키는 숫자보다 크면, 오큰수로 설정
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                answer[stack.pop()] = arr[i];
            }
            stack.push(i); // 현재 인덱스를 stack에 저장
        }

        StringBuilder sb = new StringBuilder();
        for(int num : answer)
            sb.append(num).append(" ");

        System.out.println(sb);


    }

}
