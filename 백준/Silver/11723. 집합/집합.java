import java.io.*;
import java.util.*;

public class Main {
    static int m;//수행해야 하는 연산 수
    static int s = 0;//공집합 s

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input_and_solve();
        System.out.println(sb);
    }

    private static void input_and_solve() throws Exception{

        m = Integer.parseInt(bf.readLine());

        while(m-- > 0){
            st = new StringTokenizer(bf.readLine());

            String command = st.nextToken();
            int num = -1;
            if (is_all_empty(command))
                num = Integer.parseInt(st.nextToken());

            switch (command){
                case "add":{
                    s |= (1 << (num-1));
                    //System.out.println(Integer.toBinaryString(s));

                    break;
                }
                case "check":{
                    sb.append(((s & (1 << (num - 1))) != 0) ? 1 : 0).append("\n");
                    //System.out.println(Integer.toBinaryString(s));

                    break;
                }
                case "remove":{
                    s &= ~(1 << (num-1));
                    //System.out.println(Integer.toBinaryString(s));

                    break;
                }
                case "toggle":{
                    s ^= (1 << (num-1));
                    //System.out.println(Integer.toBinaryString(s));

                    /*
                    값이 있어 1 -> 1 ====> 0으로 바꾸기
                    값이 없어 0 -> 1 =====> 1로 바꾸기
                     */
                    break;
                }
                //
                case "all":{
                    s = (1 << 20) - 1;
                    //System.out.println(Integer.toBinaryString(s));

                    break;
                }
                case "empty":{
                    s = 0;
                    //System.out.println(Integer.toBinaryString(s));

                    break;
                }
            }
        }
    }

    private static boolean is_all_empty(String s){
        if (s.equals("all") || s.equals("empty")) return false;
        else return true;
    }
}
