
import java.util.*;
import java.io.*;

public class Main {
    static int num;
    static int n;
    static ArrayList<Integer> list=  new ArrayList<>();
    static ArrayList<ArrayList<Integer>> separate = new ArrayList<>();
    static int answerIdx = -1;

    public static void main(String[] args){
        input();
        solve();

        System.out.println(answerIdx);
    }

    private static void solve(){

        while(answerIdx == -1) {
            list.add(num);//list에 들어있지 않은 수이면
            int idx = 0;

            ArrayList<Integer> toseparate = new ArrayList<>();
            while(num > 0){
                toseparate.add(num % 10);
                num /= 10;
                idx++;
            }
            separate.add(toseparate);


            int newnum = 0;
            ArrayList<Integer> fromseparate = separate.get(separate.size() - 1);
            for (int i = 0; i < fromseparate.size(); i++) {
                int newadd = 1;
                int t = n;
                if (fromseparate.get(i)  != 0){
                    while (t-- > 0) {
                        newadd *= fromseparate.get(i);
                    }
                    newnum += newadd;

                }

            }
            num = newnum;

            //num이 들어가있는지 확인
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == num){
                    answerIdx = i;
                }

            }
        }

    }

    private static void input(){
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        n = sc.nextInt();


    }
}
