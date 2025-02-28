
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

    }
    private static void dfs(int number, int jarisu){
        if (jarisu == n){ // n은 전역 변수로 목표 자릿수
            System.out.println(number);
            return;
        }

        for (int i = 1; i < 10 ; i++){
            if (i % 2 == 0){ // 짝수 제외
                continue;
            }

            int next = number * 10 + i;
            if (isPrime(next)){
                dfs(next, jarisu + 1);
            }
        }
    }

    static boolean isPrime(int n){
        if (n < 2) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
