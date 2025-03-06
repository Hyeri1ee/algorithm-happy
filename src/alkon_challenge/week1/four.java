package alkon_challenge.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class four {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        arr = new int[n][6];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 첫번째 주사위에서 6개의 면을 각각 바닥에 두는 경우 모두 시도
        int[] maxsum = new int[6];

        for (int i = 0; i < 6; i++) {
            int maxcandidate = 0;

            // 첫 주사위의 바닥과 윗면 설정
            int bottom = i;
            int bottomtop = getOppositeSideValue(i); // 반대편 인덱스

            // 첫 주사위의 최대값 계산 (바닥과 윗면 제외)
            maxcandidate += getCurrentMax(0, arr[0][bottom], arr[0][bottomtop]);

            for (int j = 1; j < n; j++) {
                int prevvalue = arr[j - 1][bottomtop]; // 이전 주사위의 윗면 값
                int bottomIndex = getIndex(j, prevvalue); // 현재 주사위에서 해당 값의 위치
                int topIndex = getOppositeSideValue(bottomIndex);

                // 현재 주사위의 최대값 (바닥, 윗면 제외) 추가
                maxcandidate += getCurrentMax(j, arr[j][bottomIndex], arr[j][topIndex]);

                // 다음 주사위를 위한 bottom, bottomtop 갱신
                bottom = bottomIndex;
                bottomtop = topIndex;
            }

            maxsum[i] = maxcandidate;
        }

        // 6가지 경우 중 최대값 출력
        int result = Arrays.stream(maxsum).max().orElse(0);
        System.out.println(result);
    }

    // 현재 주사위에서 not1과 not2를 제외한 가장 큰 값 반환
    public static int getCurrentMax(int j, int not1, int not2) {
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if (arr[j][i] != not1 && arr[j][i] != not2) {
                max = Math.max(max, arr[j][i]);
            }
        }
        return max;
    }

    // 주사위의 반대 면 인덱스 반환
    public static int getOppositeSideValue(int i) {
        switch (i) {
            case 0: return 5;
            case 1: return 3;
            case 2: return 4;
            case 3: return 1;
            case 4: return 2;
            case 5: return 0;
            default: return -1;
        }
    }

    // 현재 주사위(j)에서 특정 값(prev)의 위치(인덱스) 반환
    public static int getIndex(int j, int prev) {
        for (int i = 0; i < 6; i++) {
            if (arr[j][i] == prev) {
                return i;
            }
        }
        return -1; // 여기는 사실상 안 옴
    }
}
