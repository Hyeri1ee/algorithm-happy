
import java.io.*;
import java.util.*;
/*
14
#.#..#.#..#..#
6
 */
public class Main {
    //각 개체에 상관없이 주기 동일
    //#.. 인 마지막 # - ....####. 인 마지막 # 까지가 가장 긴 주기  ====> 주기 점점 줄여가기
    static int n;
    static char[] arr;
    static int answer;

    public static void main(String[] args) throws Exception{
        input();

        answer = Integer.MAX_VALUE;

        for (int T = 1; T <= n; T++) {
            int needed = 0;
            for (int a = 0; a < T; a++) {//주기T에 대한 residue별
                int runs = 0;
                boolean prevSharp = false;
                for (int j = a; j < n; j += T) {//각 residue에 대한 실제 위치
                    if (arr[j] == '#') {//그냥 연속된 #만 하나로 세는거
                        if (!prevSharp) runs++;
                        prevSharp = true;
                    } else {
                        prevSharp = false;
                    }
                }
                needed += runs;
            }
            answer = Math.min(answer, needed);
        }

        System.out.println(answer);
        /*
        //### 과 ### 사이의 ... 길이
        //### 길이 모으기
        int count = 1;
        for(int i = 1 ; i  < n ; i++){
            if (arr[i] == arr[i-1]){
                count++;
            }else{//달라진 경우
                if (arr[i-1] == '#')
                    lenSharp.add(count);
                else
                    lenDot.add(count);
                count= 1;
            }
        }
        if (arr[arr.length-1] == '.')
            lenDot.add(count);
        else
            lenSharp.add(count);

        //만약 lenSharp 혹은 lenDot 의 종류가 2 이상이면, lenSharp.size()가 답
        //아니면, lenSharp.get(i)가 답
        int init = lenSharp.get(0);
        for(int i = 1 ; i < lenSharp.size(); i++){
            if (init != lenSharp.get(i)){
                System.out.println(lenSharp.size());
                return;
            }
        }

        init = lenDot.get(0);
        //...으로 시작하는지
        //...으로 끝나는지
        boolean startwithdot = arr[0] == '.';
        boolean endswithdot = arr[arr.length-1] == '.';
        if (startwithdot)
            lenDot.remove(0);
        if (endswithdot)
            lenDot.remove(lenDot.size()-1);

        for(int i = 1 ; i < lenDot.size(); i++){
            if (init != lenDot.get(i)){
                System.out.println(lenSharp.size());
                return;
            }
        }

        init = lenSharp.get(0);
        if (init == 1){
            System.out.println(1);
            return;
        }else{
            System.out.println(lenSharp.size());
            return;
        }

         */


    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = bf.readLine().toCharArray();


    }
}
