
import java.io.*;

public class Main {
    static char[] arr;
    static char[] s;
    static int count = 0;
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(count);
    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String document = bf.readLine();
        String word = bf.readLine();

        int index = 0;

        while (true) {
            index = document.indexOf(word, index);//document에 word가 index 인덱스 부터 존재하면 해당 인덱스 반환
            if (index == -1) break;//없음
            count++;
            index += word.length();//index 를 word길이만큼 추가한 부분 부터 다시!!
        }
    }
}
