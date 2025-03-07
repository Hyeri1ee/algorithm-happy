
import java.io.*;
public class Main {
    static int n;
    static char[] str;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(bf.readLine());
        str = bf.readLine().toCharArray();

        if (n % 2 == 0) {
            System.out.println("NOT POSSIBLE");
            return;
        }

        int halfLength = (n - 1) / 2;  // 제거 후 남는 길이의 절반
        String candidate = null;       // 가능한 정답
        int foundCount = 0;             // 가능한 S의 개수 카운트

        for (int skipIndex = 0; skipIndex < n; skipIndex++) {
            // skipIndex에 해당하는 글자를 제거한 후 확인
            if (isValidPairAfterRemovingOneChar(skipIndex, halfLength)) {
                String possibleS = buildCandidate(skipIndex, halfLength);

                if (candidate == null) {
                    candidate = possibleS;  // 첫 번째 발견
                } else if (!candidate.equals(possibleS)) {
                    System.out.println("NOT UNIQUE");
                    return;
                }
                foundCount++;
            }
        }

        if (foundCount == 0) {
            System.out.println("NOT POSSIBLE");
        } else {
            System.out.println(candidate);
        }
    }

    // 한 글자 제거 후, 두 부분이 같은지 검사
    static boolean isValidPairAfterRemovingOneChar(int skipIndex, int halfLength) {
        for (int i = 0; i < halfLength; i++) {
            char left = str[i < skipIndex ? i : i + 1];
            char right = str[halfLength + i < skipIndex ? halfLength + i : halfLength + i + 1];
            if (left != right) return false;
        }
        return true;
    }

    // 한 글자 제거 후 가능한 S 문자열 만들기
    static String buildCandidate(int skipIndex, int halfLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < halfLength; i++) {
            sb.append(str[i < skipIndex ? i : i + 1]);
        }
        return sb.toString();
    }
}
