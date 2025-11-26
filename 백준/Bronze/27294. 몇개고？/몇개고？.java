import java.util.*; //이렇게 정의하는 거
import java.io.*;

class Main {
    static int t, s;//static 으로 정의하는게 과연 메모리 측면에서 더 우위를 점하는지 : 별차이 없음 new 몇개고()와 같은 인스턴스를 반복해서 를 만들지 않기 때문

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        t = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        boolean is280 = true;
        if (t>=12 && t<= 16 && s == 0)
            is280 = false;

        System.out.println(is280 ? "280" : "320");

    }
}
