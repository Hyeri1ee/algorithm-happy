
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] arr;
    static boolean answer = false;
    static long maincharater = 0;

    public static void main(String[] args) throws IOException {
        input();
        int i = 1;

        if (n == 1){
            System.out.println("Yes");
            return;
        }

        for(long a : arr){
            if (a == -1)
                continue;

            //여기서부터
            if (maincharater < a)//같거나 작은 거
                break;//여기서 끝남
            else if (maincharater == a){
                continue;
            }
            else{//maincharacter > a인 경우만
                maincharater +=  a;
                arr[i] = 0;
            }



            i++;
            if (i == n)
                answer = true;

        }

        if (answer)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new long[n];
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        maincharater = arr[0];
        boolean flag = false;
        for(int i = 0 ; i < arr.length ; i++){
            if (maincharater == arr[i] && !flag){
                arr[i] = -1;
                flag = true;
            }
        }
        Arrays.sort(arr); //정렬 오름차순

    }

}
