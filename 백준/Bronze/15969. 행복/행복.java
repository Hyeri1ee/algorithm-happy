
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static int n;
    static int[] arr;

    static List<Integer> arrList = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        arrList = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());

        Collections.sort(arrList);
        int small = arrList.get(0);
        Collections.sort(arrList, Comparator.reverseOrder());
        int big = arrList.get(0);

        System.out.println(big - small);

    }
}
