
import java.util.Scanner;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];
        int i = N;
        while(i > 0){
            if (i == N){//arr[0]
                arr[N-i] = 1;
                i--;
            }else{
                if (N % 2 == 1 && i == 1){
                    arr[N-i] = 3;
                    break;
                }
                arr[N-i] = 3 - arr[N-1-i];
                i--;

            }

        }


        //sb에 넣기
        for(int a:arr){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}
