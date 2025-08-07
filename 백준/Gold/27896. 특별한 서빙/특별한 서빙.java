
import java.io.*;
import java.util.*;

public class Main {
    static long N,M;
    static Queue<Long> queueList = new ArrayDeque<>();
    static long answer = 0;

    static PriorityQueue<Long> priority = new PriorityQueue<>((o1,o2) -> Long.compare(o2, o1));

    public static void main(String args[]) throws IOException{
        input();
        //solve();

        solve2();
        System.out.println(answer);
    }
    private static void solve2() {
        long count = 0;//현재까지의 불만도 총합

        while(!queueList.isEmpty()){
            long target = queueList.poll();//예상 불만도 추가값
            priority.add(target);
            count += target;//예상 총 불만도

            while (count >= M && !priority.isEmpty()){
                answer++;
                //count -= target;
                count -= 2 * priority.poll();
            }


        }
    }

   /* private static void solve(){
        int count = 0;
        while(!queueList.isEmpty()){
            long target = queueList.peek();
            long countPlusTarget = count + target;
            if (countPlusTarget >= M){
                answer++;
                count -= target;
            }
            else
                count += target;

            queueList.poll();
        }
    }*/
    private static void input() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine()," ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        st = new StringTokenizer(bf.readLine());//공백 문자들 구분자로 사용!

        for(int i = 0; i < N; i++){
            queueList.add(stoi(st.nextToken()));
        }
    }

    private static Long stoi(String s){
        return Long.parseLong(s);
    }
}
