
import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
       char c1, c2;
       int v1, v2;

        Pair(char c1, int v1, char c2, int v2) {
            this.c1 = c1;
            this.c2 = c2;
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    static int t;
    static int n;
    static Pair[] arr;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int[] left = new int[n+1];//left[i]는 i를 나머지로 갖는 k 결과 존재


    public static void main(String[] args) throws IOException {
        t = stoi(br.readLine());
        while(t-- > 0){
            int[] result = new int[n+1];
            input();
            solveLUcky();
            //check(0, result);
            //set = new HashSet<>();
            //solve(1,0, set);

        }

        System.out.println(sb);
    }
    private static void solveLUcky() {
        boolean[] cur = new boolean[7];
        cur[1] = true;//현재

        for(int i = 0 ; i < n ; i++){
            boolean[] next= new boolean[7];
            for(int j = 0 ; j < 7 ; j++){
                if (!cur[j] ) continue;

                int j1 = (arr[i].c1 == '+') ? (j + arr[i].v1) % 7 : (j * arr[i].v1) % 7;
                int j2 = (arr[i].c2 == '+') ? (j + arr[i].v2) % 7 : (j * arr[i].v2) % 7;
                next[j1] = true;
                next[j2] = true;
            }
            cur = next; //새로

        }

        if (cur[0]) sb.append("LUCKY\n");
        else sb.append("UNLUCKY\n");
    }
    /*
    private static void check(int curIdx, int[] a){
        if (curIdx == n){
            //a에 0이 있으면
            for(int i = 1; i < a.length; i++){
                if (a[i] == 0)
                    isLucky = true;
            }

            if (isLucky)
                sb.append("LUCKY\n");
            else
                sb.append("UNLUCKY\n");
            return;
        }

        int[] k = new int[7];
        k[1] = 1; k[2] = 1;
        //k 초기화 혹은 갱신
        if (curIdx != 0){
            k[1] = 0; k[2] = 0;
            for(int i = 1; i < a.length; i++){
                k[i] = a[i];
            }
        }

        Pair target =  arr[curIdx];
        int[] temp = new int[]{0,target.v1, target.v2};

        for(int i = 1; i < k.length; i++){
            if (target.c1 == '*'){
                k[i] *= target.v1;
                temp[i] = k[i];
            }else if (target.c1 == '+'){
                k[i] += target.v1;
                temp[i] = k[i];
            }

            if (target.c2 == '*'){
                k[i] *= target.v2;
                temp[i] = k[i];
            }else if (target.c2 == '+'){
                k[i] += target.v2;
                temp[i] = k[i];
            }
        }

        for(int i = 0; i < temp.length; i++){
            temp[i] %= 7;
        }

        check(curIdx+1, temp);


    }

    private static void solve(int k, int cur, HashSet<Integer> set){
        int init_k = k;
        if (cur == arr.length)
            return;

        Pair target =  arr[cur];
        int[] temp = new int[]{target.v1, target.v2};

            if (target.c1 == '*'){
                k *= target.v1;
                temp[0] = k;
                k = init_k;
            }else if (target.c1 == '+'){
                k += target.v1;
                temp[0] = k;
                k = init_k;
            }

            if (target.c2 == '*'){
                k *= target.v2;
                temp[1] = k;
                k = init_k;
            }else if (target.c2 == '+'){
                k += target.v2;
                temp[1] = k;
                k = init_k;
            }
        for(int i = 0; i < temp.length; i++){
            temp[i] %= 7;
        }
        set.add(temp[0]);
        set.add(temp[1]);

        solve(temp[0],cur + 1, set);
        solve(temp[1],cur + 1, set);

    }
*/
    private static void input() throws IOException{
        n = stoi(br.readLine());
        arr = new Pair[n];
        StringTokenizer st;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            char c1 = st.nextToken().charAt(0);
            int v1 = stoi(st.nextToken());
            char c2 = st.nextToken().charAt(0);
            int v2 = stoi(st.nextToken());
            arr[i] = new Pair(c1, v1, c2, v2);
        }
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
