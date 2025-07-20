
import java.io.*;
import java.util.*;

public class Main {
    static int t;//테스트 케이스 개수
    static ArrayList<int[]> list = new ArrayList<>(); //각 테스트 내 행, 열
    static char[][] newarr;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader bf;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        input();
        System.out.println(sb);
    }

    private static void input() throws IOException {
        t = stoi(bf.readLine());
        int c = t;
        bf.readLine();
        int i = 0;
        while (c-- > 0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            list.add(new int[]{stoi(st.nextToken()), stoi(st.nextToken())});
            getNewArr(i);
            i++;
            sb.append(solve() +"\n");
            if (c > 0) bf.readLine(); //다음 테스트케이스 전 빈 줄 처리
        }
    }

    private static int solve(){
        int ans = 0 ;

        for(int i = 0 ; i < newarr.length; i++){
            for(int j = 0 ;j < newarr[0].length; j++){
                if (newarr[i][j] == 'o'){
                    boolean check = checkIfCandy(i, j);
                    if (check){
                        ans += 1;
                    }
                }
            }
        }

        return ans;
    }

    private static boolean checkIfCandy(int i, int j){
        //상,하
        boolean result1 = false;
        boolean result2 = false;

        if (isIn(i, j, 1)){
           result1 = ( newarr[i-1][j] == 'v'&& newarr[i+1][j] == '^' );
        }

        //좌,우
        if (isIn(i, j, 0)){
            result2 = ( newarr[i][j-1] == '>'&& newarr[i][j+1] == '<' );
        }

        return result1 || result2;
    }

    private static boolean isIn(int i, int j, int which){
        if (which == 1){ //상, 하
            return ( (i-1 >= 0) && (i+1) < newarr.length);
        }else{//좌, 우
            return ( (j-1 >= 0) && (j+1) < newarr[0].length);
        }
    }

    private static void getNewArr(int i) throws  IOException{

        newarr = new char[list.get(i)[0]][];
        for(int j = 0 ; j < list.get(i)[0]; j++){
            newarr[j] = bf.readLine().toCharArray();
        }
    }
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
}
