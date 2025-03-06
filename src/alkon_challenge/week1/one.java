package alkon_challenge.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class one {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int min = 0;
        int sec = 0;
        int secsum = 0;
        for (int i = 0 ; i < 4 ; i++){
            //초 단위 입력받기
            arr.add(Integer.parseInt(bf.readLine()));
            secsum += arr.get(i);
        }
        //분, 초 로 전환
        min += secsum / 60;
        sec += secsum % 60;
        System.out.println(min);
        System.out.println(sec);


    }

}

