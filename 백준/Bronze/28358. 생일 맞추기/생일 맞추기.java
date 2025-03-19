
import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int totaldays = 0;
            int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            boolean[] forbidden = new boolean[10]; // 찬우의 아이디에 등장하는 숫자들 (금지된 숫자들)

            // 입력 처리
            int[] input = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < 10; i++) {
                if (input[i] == 1) {
                    forbidden[i] = true; // i라는 숫자는 찬우의 아이디에 포함되어 있으므로 생일에는 없어야 함
                }
            }

            // 각 날짜별로 체크
            for (int month = 1; month <= 12; month++) {
                String monthStr = String.valueOf(month);
                boolean validMonth = true;

                // 달에 금지된 숫자가 포함되어 있는지 확인
                for (char digit : monthStr.toCharArray()) {
                    if (forbidden[digit - '0']) {
                        validMonth = false;
                        break;
                    }
                }

                if (!validMonth) continue; // 이 달은 건너뜀

                int daysInMonth = days[month - 1];
                for (int day = 1; day <= daysInMonth; day++) {
                    String dayStr = String.valueOf(day);
                    boolean validDay = true;

                    // 일에 금지된 숫자가 포함되어 있는지 확인
                    for (char digit : dayStr.toCharArray()) {
                        if (forbidden[digit - '0']) {
                            validDay = false;
                            break;
                        }
                    }

                    if (validDay) {
                        totaldays++; // 유효한 날짜 카운트
                    }
                }
            }

            sb.append(totaldays).append("\n");
        }

        System.out.println(sb);
    }
}