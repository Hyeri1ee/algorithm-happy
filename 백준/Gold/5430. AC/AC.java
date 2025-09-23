
import java.io.*;
import java.util.*;

public class Main {
    /*
    앞, 뒤 뒤집기는 boolean으로 판별 true면 front에서, false면 back에서
    배열은 덱으로 저장
     */
    static int t;
    static String p;
    static int n;
    static Deque<Integer> arr = new ArrayDeque<>();

    static boolean isFront= true;

    static BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        input();
        while(t-- > 0){
            isFront = true;
            input2();
            solve();
        }

        System.out.println(sb);

    }
    private static void solve(){
        for(int i = 0 ; i < p.length() ; i++){
            char c = p.charAt(i);
            if (c == 'R')
                isFront = !isFront;
            else {//c == 'D'인 경우
                if (isFront){
                    if (!arr.isEmpty())
                        arr.removeFirst();
                    else
                    {
                        sb.append("error\n");
                        return;
                    }
                }else{
                    if (!arr.isEmpty())
                        arr.removeLast();
                    else
                    {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        //[숫자, 숫자]
        sb.append("[");

        while (!arr.isEmpty()) {
            if (isFront) {
                sb.append(arr.pollFirst());
            } else {
                sb.append(arr.pollLast());
            }
            if (!arr.isEmpty()) sb.append(",");
        }

        sb.append("]\n");
    }
    private static void input2() throws Exception{
        p = bf.readLine();
        n = Integer.parseInt(bf.readLine());
        arr.clear();

        st = new StringTokenizer(bf.readLine(), "[],");
        for(int i = 0 ; i < n; i++){

            arr.add(Integer.parseInt(st.nextToken()));
        }

    }
    private static void input() throws Exception{
        st =new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());

    }
}
