import java.io.*;
import java.util.*;

class Main{
    static int n;
    static double[] arr;
    public static void main(String[] args) throws Exception{
        input();
        
        //카데인 알고리즘
        double globalAns = arr[0];
        double localAns = arr[0];
        
        for (int i = 1; i< n; i++){
            localAns = Math.max(localAns * arr[i], arr[i]);
            globalAns = Math.max(globalAns, localAns);
        }
        
        System.out.printf("%.3f", globalAns);
        
    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new double[n];
        
        for(int i = 0; i < n ; i++){
            arr[i] = Double.parseDouble(bf.readLine());
        }
    }
}