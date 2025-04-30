
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long a1 = change(arr[0], arr[1]);
        long a2 = change(arr[2], arr[3]);
        System.out.println(a1 + a2);
    }

    private static long change(int a, int b){
        return Long.parseLong(String.valueOf(a) + String.valueOf(b));
    }
}
