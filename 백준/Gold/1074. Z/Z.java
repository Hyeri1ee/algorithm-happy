
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long n, r, c;
    static long num = 0;

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }
    private static void solve(){
        int size = (int) Math.pow(2, n);

        while(size > 1){
            size /= 2;
            check(size);
        }

        System.out.println(num);

    }
    private static void check(int size){
        int point = 0; // 1 2 3 4
        /*
        1 2
        3 4
         */
        if (r > size-1){
            if (c > size -1){
                point = 4;
                r -= size;
                c -= size;
            }else//c <= size - 1
            {
                point = 3;
                r -= size;
            }

        }else{//r <= size-1
            if (c > size -1){
                point = 2;
                c -= size;
            }else//c <= size - 1
                point = 1;
        }

        switch(point){
            case 1:{
                num += 0;
                break;
            }
            case 2:{
                num += size * size;
                break;
            }
            case 3:{
                num += 2 * size * size;
                break;
            }
            case 4:{
                num += 3 * size * size;
                break;
            }
        }

        return;
    }
    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = stoi(st.nextToken());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());
    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
