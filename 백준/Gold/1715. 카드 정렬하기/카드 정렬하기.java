
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        //n값 입력받기
        n = Integer.parseInt(bf.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        //n개의 카드 묶음 개수 입력 받기
        for (int i = 0 ;  i < n ; i++){
            pq.offer( Long.parseLong(bf.readLine()) );
        }


        long  sum = 0;
        for (int i = 1 ; i < n ; i++){
            long first = pq.poll();
            long second = pq.poll();
            long newone = first+ second;
            sum += newone;
            pq.offer(newone);
        }
        System.out.println(sum);
    }

}
