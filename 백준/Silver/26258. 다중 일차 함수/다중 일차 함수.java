
import java.io.*;
import java.util.*;

/*
5
0 0
1 5
2 5
3 3
6 10
3
2.5
4
1.5
 */
class xy{
    int x, y;
    xy(int a, int b){
        x = a;
        y = b;
    }
}
public class Main {
    static int n;
    static int k;

    static xy[] graph;
    static double[] karr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }
    private static void solve(){
        for(int a = 0; a < k; a++){
            double target = karr[a];


            int left =upperbound2(target);
            //기울기
            double lint = (double) (graph[left].y - graph[left+1].y) / (graph[left].x - graph[left+1].x);

            check(lint);
        }

        System.out.println(sb.toString());

    }

    private static int upperbound2(double target){
        int left = 0;
        int right = n - 2; 
        while (left <= right) {
            int mid = (left + right) / 2;
            if (graph[mid + 1].x > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;  
    }


    private static void check(double lint){
        if (lint < 0){
            sb.append("-1\n");
        }else if (lint > 0){
            sb.append("1\n");
        }else{
            sb.append("0\n");
        }
    }
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(bf.readLine());

        graph = new xy[n];
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            graph[i] = new  xy(stoi(st.nextToken()),stoi(st.nextToken()));

        }

        k = stoi(bf.readLine());
        karr = new double[k];
        for(int i = 0 ; i < k ; i++){
            karr[i] = stoi2(bf.readLine());
        }
    }

    private static double stoi2(String s){
        return Double.parseDouble(s);
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
