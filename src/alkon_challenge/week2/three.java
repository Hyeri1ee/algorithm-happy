package alkon_challenge.week2;

import java.io.*;
import java.util.*;

public class three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String S = br.readLine();

        if (canMakePalindrome(n, S)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean canMakePalindrome(int n, String S) {
        Map<Character, Integer> leftFreq = new HashMap<>();
        Map<Character, Integer> rightFreq = new HashMap<>();

        int half = n / 2;

        // 왼쪽 절반 문자 개수 저장
        for (int i = 0; i < half; i++) {
            char ch = S.charAt(i);
            leftFreq.put(ch, leftFreq.getOrDefault(ch, 0) + 1);
        }

        // 오른쪽 절반 문자 개수 저장
        for (int i = n - half; i < n; i++) {
            char ch = S.charAt(i);
            rightFreq.put(ch, rightFreq.getOrDefault(ch, 0) + 1);
        }

        // 두 절반에서 문자를 서로 교환하여 팰린드롬을 만들 수 있는지 확인
        int diffCount = 0;
        for (char ch : leftFreq.keySet()) {
            int leftCount = leftFreq.getOrDefault(ch, 0);
            int rightCount = rightFreq.getOrDefault(ch, 0);
            diffCount += Math.abs(leftCount - rightCount);
        }

        // 짝수 차이만큼 조정 가능하면 팰린드롬 가능
        return diffCount % 2 == 0;
    }
}
