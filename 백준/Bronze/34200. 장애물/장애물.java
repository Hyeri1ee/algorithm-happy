
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] x;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        x = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


//짜피 장애물은 '2'로 넘고, 나머지 길이를 모으면, 1 은 '1'로 2는 '2'로 3은 '2'+'1'로 4는 '2'+'2'로

        int x_start = 0;
        for(int i = 0 ; i < x.length; i++){
            if (x_start >= x[i]) {System.out.println(-1); return;}

            int x_end = x[i] - 1;
            int len  = x_end - x_start;
            if (len > 0)
                arr.add(len);
            x_start = x_end + 2;
        }

        //count 세기
        for(int i= 0; i < arr.size(); i++){
            if (arr.get(i) == 1) count++;
            else
            {
                int a = arr.get(i) / 2;
                int b = arr.get(i) % 2;
                count += (a+b);
            }
        }


        System.out.println(count + x.length);
        
    }

}
