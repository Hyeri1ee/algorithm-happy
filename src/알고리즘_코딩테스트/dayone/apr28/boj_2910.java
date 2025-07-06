package 알고리즘_코딩테스트.dayone.apr28;

import java.io.*;
import java.util.*;

/*
HashMap<Integer, Integer> frequency : 숫자, 빈도
LinkedHashMap<integer, Integer> order : 숫자, 가장 먼저 등장한 순서

입력받을때 동시에 frequency, order에 저장후
빈도가
 */
public class boj_2910 {
    static int n, c;
    static HashMap<Integer, Integer> frequency = new HashMap<>();
    static LinkedHashMap<Integer, Integer> order = new LinkedHashMap<>();
    static List<Integer> list;//

    public static void main(String[]args)throws Exception{
        input();
        solve();
    }

    private static void solve(){

        list.sort((o1, o2) -> {
            int f1 = frequency.get(o1);
            int f2 = frequency.get(o2);
            if (f1 != f2) {
                return Integer.compare(f2, f1); // 빈도수 내림차순
            }
            return Integer.compare(order.get(o1), order.get(o2)); // 먼저 등장한 순서
        });

        StringBuilder sb = new StringBuilder();
        for (int num : list){
            for(int i = 0 ; i < frequency.get(num); i++){
                sb.append(num + " ");
            }
        }

        System.out.println(sb);
    }

    private static void input()throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = stoi(st.nextToken());
        c = stoi(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        while(st.hasMoreTokens()){
            int num = stoi(st.nextToken());
            if (frequency.containsKey(num)){
                frequency.put(num, frequency.get(num)+1);
            }
            else{
                frequency.put(num, 1);
                order.put(num, order.size()+1);
            }
        }
        list = new ArrayList<>(frequency.keySet());

    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
