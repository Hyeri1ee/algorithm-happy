import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static class pair{
        private String word;
        int num;

        public pair(String w, int n){
            this.word = w;
            this.num = n;
        }
    }
    static Scanner sc =new Scanner(System.in);
    static Map<String, Integer> map = new HashMap<>();

    static List<String> ans = new ArrayList<>();//정답 저장

    public  static void main(String[] args){
        input();
        solve();
    }
    private static void solve(){
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());//map은 collection 적용 못하므로
        Collections.sort(list, (a,b)-> {
            if (a.getValue().equals(b.getValue())){
                return a.getKey().compareTo(b.getKey());//사전순
            }else{
                return b.getValue() - a.getValue();
            }
        });

        System.out.println(list.get(0).getKey());
    }

    private static void input(){
        n = sc.nextInt();
        sc.nextLine();//개행문자 제거
        for(int i=0;i<n;i++){
            String s = sc.nextLine();
            map.put(s, map.getOrDefault(s , 0) + 1);
        }
    }
}
