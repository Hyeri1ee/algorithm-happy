
import java.io.*;

public class Main {
    static int n;
    static long answer = 0;
    static long[] saved;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        saved = new long[n+1];
        saved[1] = 1;
        
        if (n < 2){
            System.out.println(saved[n]);
            return;
        }
        saved[2] = 1;
        for(int i = 3; i <= n ; i++){
            saved[i] = saved[i-1] + saved[i-2];
        }
        System.out.println(saved[n]);
    }

}
