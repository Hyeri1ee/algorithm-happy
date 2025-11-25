
import java.util.*;

public class Main {
    public static void main(String[] args){
        String score;
        Scanner sc = new Scanner(System.in);
        score = sc.nextLine();

        HashMap<String, Float> map = new HashMap<>();
        init(map);
        System.out.println(map.get(score));
    }
    private static void init(HashMap<String, Float> map){
        map.put("A+", 4.3f);
        map.put("A0",4.0f);
        map.put("A-",3.7f);
        map.put("B+", 3.3f);
        map.put( "B0", 3.0f);
        map.put( "B-", 2.7f);
        map.put( "C+", 2.3f);
        map.put( "C0", 2.0f);
        map.put( "C-", 1.7f);
        map.put( "D+", 1.3f);
        map.put( "D0", 1.0f);
        map.put( "D-", 0.7f);
        map.put( "F", 0.0f);
    }
}
