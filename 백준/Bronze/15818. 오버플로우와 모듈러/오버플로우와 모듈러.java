
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long result = 1 ;
        for (int i = 0 ; i < arr.length; i++){
            result = ( result * (arr[i] % m) )  % m;
        }
        System.out.println(result % m);


    }
}
