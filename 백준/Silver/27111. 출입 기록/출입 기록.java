import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static HashMap<Integer, Integer> maps = new HashMap<>();
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());


        for(int i =0; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (maps.containsKey(a)){
                int cur = maps.get(a);
                if (cur != b)
                    maps.put(a,b);
                else//cur == b인 경우
                {
                    count++;
                    maps.put(a,b);
                }
            }else{//a가 없으면
                if (b == 0)
                    count++;

                maps.put(a,b);

            }
        }


        //전체 체크
        for(int key : maps.keySet()){
            int val = maps.get(key);
            if (val == 1)
                count++;
        }

        System.out.println(count);

    }

}
