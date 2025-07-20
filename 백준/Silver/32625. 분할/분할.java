
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean poss;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(bf.readLine());
        arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
    private static void solve(){
        //arr.size()를 나누어 떨어지는 값을 기준으로 max, min 값 각 섹션마다 같은지 갱신
        int size = arr.length;
        for(int i = size-1 ; i > 0 ; i--){
            int minmax = 0; //min + max
            poss = true; //가능

            if (size % i == 0){//구간 후보가 될 수 있는 i값인 경우
                /*
                위 if 조건문 보다는 if(size % i != 0 ) continue가 더 깔끔
                 */
                for(int j = 0; j < size; j+=i){ //arr인덱스 j부터 j+1Rkwl
                    int min = getMin(j, i);
                    int max = getMax(j, i);
                    int sum = min + max;

                    if (minmax == 0) minmax = sum;
                    else if (minmax != sum){
                        poss = false;
                        break;
                    }
                }

                if (poss){
                    System.out.println("1");
                    return;
                }
            }



        }
        System.out.println("0");
        return;


    }

    private static int getMin(int j, int i){
        int min = Integer.MAX_VALUE;
        for (int k = j; k < j+i; k++){
            if (min > arr[k])
                min = arr[k];
        }
        return min;
    }

    private static int getMax(int j, int i){
        int max = 0;
        for (int k = j; k < j+i; k++){
            if (max < arr[k])
                max = arr[k];
        }
        return max;
    }
}
