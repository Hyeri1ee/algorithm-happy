
import java.io.*;
import java.util.*;

public class Main {
    static int seung_x, seung_y;
    static int target_x, target_y;
    static int mak_x, mak_y;

    static int result = -1;

    public static void main(String[] args) throws Exception{
        input();
        solve();
    }
    private static void solve(){
        //seung과 target의 x,y좌표 중 몇개 가 같은지
        int state = isInWhatState();

        switch (state){
            case 1:{
                result = isInWhatState2(1);break;
            }
            case 2:{
                result = isInWhatState2(2);break;
            }
            case 3:{
                result = 1;break;
            }
        }

        System.out.println(result);
    }

    private static int isInWhatState2(int cur){
        if (cur == 1){
            if (seung_x == mak_x && between(mak_y,seung_y,target_y))
                    return 2;
            return 0;
        }else if (cur == 2){
            if (seung_y == mak_y && between(mak_x,seung_x,target_x))
                    return 2;
            return 0;
        }
        return -1;

    }

    private static boolean between(int a, int b, int c){
        return (b <= a && a <= c) || (c <= a && a <= b);
    
    }

    private static int isInWhatState(){
        boolean checkx = seung_x == target_x;
        boolean checky = seung_y == target_y;

        if (checkx && ! checky) return 1;
        else if (!checkx && checky) return 2;
        else if (!checkx && !checky) return 3;
        return  -1;
    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //seung
        st = new StringTokenizer(bf.readLine());
        seung_x = Integer.parseInt(st.nextToken());
        seung_y = Integer.parseInt(st.nextToken());
        //target
        st = new StringTokenizer(bf.readLine());
        target_x = Integer.parseInt(st.nextToken());
        target_y = Integer.parseInt(st.nextToken());
        //막는다
        st = new StringTokenizer(bf.readLine());
        mak_x = Integer.parseInt(st.nextToken());
        mak_y = Integer.parseInt(st.nextToken());
    }
}
