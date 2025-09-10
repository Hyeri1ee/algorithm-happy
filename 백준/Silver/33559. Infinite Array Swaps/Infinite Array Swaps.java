import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static HashMap<Integer, Integer>[] map = new HashMap[2];
    static HashMap<Integer, Integer> result = new HashMap<>();//공통
    static HashMap<Integer, Integer> result1 = new HashMap<>();//map[0]에만 존재
    static HashMap<Integer, Integer> result2 = new HashMap<>();
    static boolean[] visited2;

    public static void main(String[] ar) throws Exception{
        input();
        int count = 0;

        for(int i : map[0].keySet()){
            if (map[1].containsKey(i)){//map[0]와 map[1] 모두에 들어있는거
                int cnt = Math.min(map[0].get(i), map[1].get(i));
                result.put(i, cnt);

                //남은거 넣기
                if (map[0].get(i) > cnt) {
                    result1.put(i, map[0].get(i) - cnt);
                }
                if (map[1].get(i) > cnt) {
                    result2.put(i, map[1].get(i) - cnt);
                }

            }//end of if
            else{
                //map[0]에만 있는 경우
                result1.put(i, map[0].get(i));
            }


        }

        //map[1]에만 있는 경우
        for(int i : map[1].keySet()){
            if (!map[0].containsKey(i)){
                result2.put(i, map[1].get(i));
            }
        }


        //count 갱신 (result로)
        for(int i : result.keySet()){
            count += result.get(i);
        }

        //print
        StringBuilder sb = new StringBuilder();
        sb.append(count+"\n");
        for(int p : result.keySet()){
            int c = result.get(p);
            while(c-- > 0)
                sb.append(p+" ");
        }
        for(int p : result1.keySet()){
            int c = result1.get(p);
            while(c-- > 0)
                sb.append(p+" ");
        }
        sb.append("\n");
        for(int p : result.keySet()){
            int c = result.get(p);
            while(c-- > 0)
                sb.append(p+" ");
        }
        for(int p : result2.keySet()){
            int c = result2.get(p);
            while(c-- > 0)
                sb.append(p+" ");
        }

        System.out.println(sb);


    }

    private static void input() throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        visited2 = new boolean[n];
        for(int i = 0; i < 2; i++){
            map[i] = new HashMap<>();
            int[] arr = Arrays.stream(bf.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int a : arr) {
                map[i].put(a, map[i].getOrDefault(a, 0) + 1);
            }

        }
    }
}
