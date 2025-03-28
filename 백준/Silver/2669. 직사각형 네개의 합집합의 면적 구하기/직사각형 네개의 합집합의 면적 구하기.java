import java.util.*;
import java.io.*;

public class Main{
    static int[][] results = new int[101][101];
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        for (int l = 0; l < 4; l++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            for (int i = a; i < c; i++) {
                for (int j = b; j < d; j++) {
                    results[i][j] = 1;
                }
            }
        }

        //input

        int answer = 0;
        for(int i = 1 ; i <= 100 ; i++){
            for (int j =1 ; j <= 100 ; j++){
                if (results[i][j] == 1){
                    answer += 1;
                }
            }
        }
        System.out.println(answer);

    }
}