package 알고리즘_코딩테스트.dayone.apr28;

import java.io.*;
import java.util.*;

public class boj1620 {
    static int n, m;
    static HashMap<Integer, String> maps;
    static HashMap<String, Integer> reverseMaps;

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static public void main(String[] args) throws IOException{
        input();
        solve();

        System.out.println(sb);
    }

    private static void solve()throws IOException{
        while(m-- > 0){
            String input = bf.readLine();
            try{//if (49 <= S.charAt(0) && S.charAt(0) <= 57) {, if (Character.isDigit(cmd.charAt(0))) {
                //숫자인경우
                int num = stoi(input);
                sb.append(maps.get(num)+"\n");
            }catch(NumberFormatException e){
                //문자열인경우
                sb.append(reverseMaps.get(input)+1).append("\n");
            }

        }
    }

    private static void input()throws IOException {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());


        maps = new HashMap<>();
        reverseMaps = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            String name = bf.readLine();
            maps.put(i+1, name);
            reverseMaps.put(name, i);
        }
    }

    private static int stoi(String a){
        return Integer.parseInt(a);
    }
}
