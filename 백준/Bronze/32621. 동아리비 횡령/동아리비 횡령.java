import java.util.*;

public class Main {
    public static void main(String[] ar) {
        Scanner sc = new Scanner(System.in);
        String r = sc.nextLine().trim();

        int i = r.indexOf('+');
        // '+' 없거나, 양쪽에 숫자 없음
        if (i == -1 || i == 0 || i == r.length() - 1) {
            System.out.println("No Money");
            return;
        }

        String str1 = r.substring(0, i);
        String str2 = r.substring(i + 1);

        // 양쪽이 같아야 함
        if (!str1.equals(str2)) {
            System.out.println("No Money");
            return;
        }

        // 숫자 형식 검사
        if (!isValidPositiveNumber(str1)) {
            System.out.println("No Money");
            return;
        }

        System.out.println("CUTE");
    }

    private static boolean isValidPositiveNumber(String s) {
        // 숫자만으로 구성되어야 함
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }

        if (s.startsWith("0")) return false;

        // 0이면 안 됨 (양의 정수만)
        if (s.equals("0")) return false;

        return true;
    }
}
