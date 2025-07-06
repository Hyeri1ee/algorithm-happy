package codingtest.StackQueue;
import java.io.*;
import java.util.*;

/*
..........................
.....QX.........QXX.......
.QXX.XX.......QXXXXQX.....
QXXXQXXQXXQ...XXXXXXXQXXXX
구하는거 : 건물이 최소한 몇 채인지
풀이 :
    기준 - 건물의 높이가 변하는 부분을 기준으로 "건물 높이"를 스택에 넣기
          스택에 넣은 "건물 높이-1"이하 값이 오면 스택에서 빼기
    예시 - (스택) 1
          (스택) 1 2
          (스택) 1
          (스택) 1 3
          (스택) 1
          (스택)
          (스택) 2
          (스택) 2 3
          (스택) 2
          (스택)

-----
4
1 4
2 3
3 5
4 4
...X....
.X.XX.....................
.XXXX....
.XXXX....
.XXXX..
 */
class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class 스카이라인_쉬운거_1863 {
    static int n;
    static ArrayList<Pair> list = new ArrayList<>();
    static int answer;

    public static void main(String[] args) throws IOException{
        input();
        solve();
        System.out.println(answer);
    }

    static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int cn = n;
        while(cn-- > 0){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pair(x,y));
        }
    }
    static void solve(){
        Stack<Integer> stacks = new Stack<>();
        int newY = 0;

       /*
       높이 증가 push
       높이 감소 pop
        */
        for(int i = 0 ;i < list.size(); i++){
            newY = list.get(i).y;
            //높이 감소 pop
            while (!stacks.isEmpty() && stacks.peek() > newY) {
                stacks.pop();
                answer++;
            }

            //높이 증가 push
            if (newY > 0 && (stacks.isEmpty() || stacks.peek() < newY)) {
                stacks.push(newY);
            }


        }

        while (!stacks.isEmpty()) {
            if (stacks.pop() > 0) answer++;
        }
    }
}
