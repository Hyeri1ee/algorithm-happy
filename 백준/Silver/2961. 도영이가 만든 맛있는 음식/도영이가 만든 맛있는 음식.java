import java.io.*;
import java.util.*;

/*
subset (택하는 재료 집합)
 */
public class Main {
    static class pairs{
        long sour;//신
        long bitter;//쓴

        public pairs(long sour, long bitter){
            this.sour = sour;
            this.bitter = bitter;
        }

        @Override
        public String toString(){
            return "bitter : " + bitter +", sour : " + sour;
        }

    }
    static int n;
    static long differ = Long.MAX_VALUE;

    static ArrayList<pairs> save = new ArrayList<>();

    public static void main(String[] args)throws Exception{
        input();
        //디버깅용
        //save.stream().forEach(System.out::println);
        solve();
        print();

    }
    private static void print(){
        System.out.println(differ);
    }
    private static void solve(){
        int subsetNum = (1 << n);//n인덱스 1, 나머지 0
        for(int subset = 1; subset < subsetNum; subset++){//subset = 0인 경우는 없음

            long multiply_sour = 1;
            long plus_bitter = 0b0;

            //디버깅용
            //System.out.println("subset : " + subset);

            for(int i=0; i< n; i++){
                if ((subset & (1 << i)) != 0){
                    pairs target = save.get(i);
                   // System.out.println("bitter : " + target.bitter +", sour : " + target.sour);


                    plus_bitter += target.bitter;
                    multiply_sour *= target.sour;


                }

            }
            differ = Math.min(Math.abs(plus_bitter - multiply_sour), differ);
        }

    }

    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bf.readLine());
        for(int i =0; i< n; i++){
            st = new StringTokenizer(bf.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            save.add(new pairs(x , y));
        }
    }
}
