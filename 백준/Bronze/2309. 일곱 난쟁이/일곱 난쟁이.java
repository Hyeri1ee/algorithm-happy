
import java.util.*;

public class Main {
    static int[] arr = new int[9];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)
    {
        int sum = 0;

        Scanner sc = new Scanner(System.in);
        int num = 0;
        while(num < 9)
        {
            arr[num] = sc.nextInt();
            sum += arr[num];
            num++;
        }

        //정렬
        Arrays.sort(arr);

        int gap = sum - 100;
        int omit1 = -1 , omit2 = -1;

        for(int i = 0; i < 8; i++){//arr[i] 는 꼭 넣음
            int gapLeft;
            if (gap-arr[i] <= 0)
                continue;
            else
                gapLeft = gap-arr[i];

            for(int j = i+1; j < 9; j++){
                if (gapLeft == arr[j]){
                    omit1 = i;
                    omit2 = j;
                    break;
                }

            }
        }


        //출력
        for(int i = 0; i <= 8; i++){
            if (i == omit1 || i == omit2)
                continue;
            sb.append(arr[i]+"\n");
        }

        System.out.println(sb);


    }
}
