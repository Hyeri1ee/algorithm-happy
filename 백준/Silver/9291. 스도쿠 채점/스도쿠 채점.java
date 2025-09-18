import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    static int num = 0;

    public static void main(String[] args) throws Exception {
        input();
        System.out.println(sb);
    }

    private static void input() throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine().trim());
        arr = new int[9][9];

        while (t-- > 0) {
            boolean finalCheck = true;

            //입력
            for (int i = 0; i < 9; i++) {
                arr[i] = Arrays.stream(bf.readLine().trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            //행, 열 검사
            for (int i = 0; i < 9 && finalCheck; i++) {
                boolean[] rowCheck = new boolean[9];
                boolean[] colCheck = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    int rowVal = arr[i][j];
                    int colVal = arr[j][i];
                    if (rowVal < 1 || rowVal > 9 || rowCheck[rowVal - 1]) {
                        finalCheck = false;
                        break;
                    }
                    if (colVal < 1 || colVal > 9 || colCheck[colVal - 1]) {
                        finalCheck = false;
                        break;
                    }
                    rowCheck[rowVal - 1] = true;
                    colCheck[colVal - 1] = true;
                }
            }

            // 3x3 박스 검사
            for (int i = 0; i < 9 && finalCheck; i += 3) {
                for (int j = 0; j < 9 && finalCheck; j += 3) {
                    boolean[] boxCheck = new boolean[9];
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            int val = arr[x][y];
                            if (val < 1 || val > 9 || boxCheck[val - 1]) {
                                finalCheck = false;
                                break;
                            }
                            boxCheck[val - 1] = true;
                        }
                        if (!finalCheck) break;
                    }
                }
            }

            // 빈 줄 읽기
            if (t > 0) bf.readLine();

            // 결과 출력
            sb.append("Case " + ++num + ": " + (finalCheck ? "CORRECT" : "INCORRECT") + "\n");
        }
    }
}
