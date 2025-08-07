
import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[5];
    static int answer = 0;

    public static void main(String[] args)throws IOException{
        input();
        solve();
    }
    private static void solve(){
        while(check()){
         answer++;
        }
        System.out.println(answer);
    }

    //EMH 중 개수가 0 이 아닌 경우
    private static boolean check(){
        boolean flag4 = false, flag2 = false, flag0 = false;
        //ArrayList<Integer> list = new ArrayList<>();
        if (arr[4] == 0)
        {
            if (arr[3] > 0)
            {
                arr[3]--;
                flag4 = true;
            }
        }else{
            arr[4]--;
            flag4 = true;
        }

        if (arr[0] == 0)
        {
            if (arr[1] > 0)
            {
                arr[1]--;
                flag0 = true;
            }
        }else{
            arr[0]--;
            flag0 = true;
        }


        if (arr[2] == 0)
        {
            //큰 거에서 가져오기
            if (arr[1] > arr[3])
            {
                arr[1]--;
                flag2 = true;
            }else if (arr[1] < arr[3])
            {
                arr[3]--;
                flag2 = true;
            }else if (arr[3] > 0){
                arr[3]--;
                flag2 = true;
            }else if (arr[1] > 0){
                arr[1]--;
                flag2 = true;
            }
        }else {
            arr[2]--;
            flag2 = true;
        }

        return flag0 && flag2 && flag4;
    }
    private static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
}
