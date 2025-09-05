
import java.io.*;
import java.util.*;

public class Main {
    /*
모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다

end 오면 끝내기
     */
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<Character> aeiou = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        input();
        solve();

        System.out.println(sb);
    }
    private static void solve(){

        for(String word : list){
            boolean rule1 = false; //모음 하나를 반드시 포함 = true -----> 기대 rule1
            boolean rule2 = false; //모음 3개, 자음 3개 연속으로 옴  = true -----> 기대 !rule2
            boolean rule3 = false; //같은 글자 연속 두 번 옴 = true ------> 기대 !rule3

            for(int i = 0 ; i < word.length(); i++){
                //rule1갱신
                if (!rule1)
                {
                    if (aeiou.contains(word.charAt(i)))
                        rule1 = true;
                }

                //rule2갱신
                if (!rule2 && i >= 2)//2 1 0 부터 적용
                {
                    char c1 = word.charAt(i-2);
                    char c2 = word.charAt(i-1);
                    char c3 = word.charAt(i);

                    boolean 모음연속 = aeiou.contains(c1) && aeiou.contains(c2) && aeiou.contains(c3);
                    boolean 자음연속 = !aeiou.contains(c1) && ! aeiou.contains(c2) && ! aeiou.contains(c3);
                    if ( 모음연속 || 자음연속)
                        rule2 = true;
                }

                //rule3갱신
                if (!rule3 && i >= 1)// 1 0 부터 적용
                {
                    char c1 = word.charAt(i-1);
                    char c2 = word.charAt(i);

                    if (c1 == c2 && (c1 == 'e' || c1 == 'o'))//같은 글자 연속 두번, ee ,oo 이외 케이스
                        continue;
                    else if (c1 == c2)
                        rule3 = true;

                }
            }

            if (rule1 && !rule2 && !rule3)
                sb.append("<"+word+"> is acceptable.\n");
            else
                sb.append("<"+word+"> is not acceptable.\n");

        }
    }
    private static void input() throws Exception{
        BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String s = bf.readLine();
            if (s.equals("end"))
                break;
            list.add(s);
        }

        //aeiou
        aeiou.add('a');
        aeiou.add('e');
        aeiou.add('i');
        aeiou.add('o');
        aeiou.add('u');

    }
}
