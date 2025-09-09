
import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int[][] arr;
    static public void main(String[] args) throws Exception{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][];
        for(int i =  0;i < n; i++){
            arr[i] = (
                    Arrays.stream(bf.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray()
            );


        }//end of for


        int max = Integer.MIN_VALUE;
        for(int i =0; i < n; i++){
            int a, b,c;
            //런
            Arrays.sort(arr[i], 0,2);
            a = arr[i][1];

            //트릭
            Arrays.sort(arr[i], 2, 7);
            b = arr[i][6];
            c = arr[i][5];

            max = Math.max(max, a+b+c);
        }

        System.out.println(max);

    }
}
