package 알고리즘_코딩테스트.dayone.apr28;

import java.io.*;
import java.util.*;


/*
HashSet<String> sets = [headgear, eyewear]
HashMap<String, Integer> maps = [<headgear,2> , <eyewear,1>]
 */
public class boj9375 {
    static int t;
    static int m;
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, Integer> maps = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws Exception{
        t = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < t ;i++){
            maps = new HashMap<>();
            int tResult = 1;

            m = Integer.parseInt(bf.readLine());
            for(int j = 0 ; j < m ;j++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String detail = st.nextToken();
                String category = st.nextToken();

                //category를 포함하면
                if (maps.keySet().contains(category)){
                    int value = maps.get(category) + 1;
                    maps.put(category, value);//왜 value++은 안됌?
                }else{
                    maps.put(category, 1);
                }

            }

            for(int value : maps.values()){
                tResult *= (value+1);//1은 아무것도 안 택하는 경우
            }
            tResult -= 1; //아무것도 안 입는 경우 빼기
            sb.append(tResult+"\n");
        }//테스트 케이스
        System.out.println(sb);
    }


}
