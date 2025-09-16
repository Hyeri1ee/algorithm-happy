
import java.io.*;
import java.util.*;

public class Main {
    static class person implements Comparable<person> {
        int age, num;
        String name;
        public person(int age, String name, int num) throws Exception{
            this.age = age;
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(person o2) {
            int order1 = this.age - o2.age;
            int order2 = this.num - o2.num;
            if (order1 == 0)
                return order2;
            else
                return order1;
        }
    }
    static int n;
    static ArrayList<person> ps = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        input();
        Collections.sort(ps);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            sb.append(ps.get(i).age + " " + ps.get(i).name+"\n");
        }
        System.out.println(sb);

    }
    private static void input() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(bf.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            ps.add(new person(age, name, i));
        }
    }
}
