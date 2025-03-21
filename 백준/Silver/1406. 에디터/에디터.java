import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기 문자열 입력 -> 스택에 저장
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char ch : bf.readLine().toCharArray()) {
            stack1.push(ch);
        }

        // 명령어 개수
        int n = Integer.parseInt(bf.readLine());

        // 명령어 처리
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();

            switch (command) {
                case "L": // 커서를 왼쪽으로 이동
                    if (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    break;
                case "D": // 커서를 오른쪽으로 이동
                    if (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                    break;
                case "B": // 커서 왼쪽 문자 삭제
                    if (!stack1.isEmpty()) {
                        stack1.pop();
                    }
                    break;
                case "P": // 커서 왼쪽에 문자 추가
                    stack1.push(st.nextToken().charAt(0));
                    break;
            }
        }

        // 최종 문자열 생성
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            sb.append(stack2.pop());
        }

        System.out.println(sb);
    }
}
