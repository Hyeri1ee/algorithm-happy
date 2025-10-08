
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static boolean[] isprime;
    static ArrayList<Integer> list =  new ArrayList<>();
    static long[] sum;

    public static void main(String[] a){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        isprime = new boolean[n+1];
        Arrays.fill(isprime, true);
        isprime[0] = false;
        isprime[1] = false;


        for(int i = 2; i * i <= n;i++){
            if (isprime[i]){
                for(int j = i*i; j<= n;j+=i){
                    isprime[j] = false;
                }
            }
        }


        list.add(0);
        for(int i=1;i<= n;i++){
            if(isprime[i]) list.add(i);
        }

        sum = new long[list.size()];
        sum[0] = 0;
        for (int i = 1; i < list.size(); i++) {
            sum[i] = sum[i-1] + list.get(i);
        }

        int count=0;
        int start = 0;
        int end =1;
        while(end < list.size()){
            long diff = sum[end] - sum[start];
            if (diff > n) start++;
            else if (diff < n) end++;
            else {
                count++;
                start++;
                //end++;
            }
        }

        System.out.println(count);



    }
}
