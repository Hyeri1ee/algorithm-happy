
import java.util.*;
/*
0
1
2
3
4
5
6
7
8
9

1 0

2 1
2 0

3 2
3 1
3 0

4 3
4 2
4 1
4 0

5 4
5 3
5 2
5 1
5 0
 */

public class Main {
    static int n;
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        if (n <= 10 ) System.out.println(n);
        else if (n > 1022)//987654321
        {
            System.out.println(-1);
        }else{
            for(int i = 0; i < 10; i++){//여기서 i는 가장 첫번째로 오는 수
                dfs(i, 1);
            }
            Collections.sort(arr);
            Long ans = arr.get(n);
            System.out.println(ans);
        }


    }

    private static void dfs(long num, int idx){
        if (idx > 10) return;//9876543210 이 최대이기때문에

        arr.add(num);//새로 만들어진 수를 arr에 집어넣기
        for(int i=0; i< num % 10; i++){//num을 10으로 나눈 나머지 전까지만 다음 자리에 넣을 수 있음
            dfs((num * 10 + i), idx+1);
        }

    }
}
