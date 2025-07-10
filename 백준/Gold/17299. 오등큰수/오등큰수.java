
import java.io.*;
import java.util.*;

/*
A = [1,1,2,3,4,2,1]
F함수
    [3,3,2,1,1,2,3] -> O(n)
NGF함수
-1, -1, 1, 2, 2, 1, -1 -> O(n)

=======


 */
public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws  IOException{
        input();
        solve();
    }
    public static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = Arrays.stream(bf.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void solve(){
        //1. F함수 : 등장한 횟수 적는 배열 -> O(n)
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (maps.containsKey(arr[i])) {
                maps.put(arr[i], maps.get(arr[i]) + 1);//다시 저장
            } else {
                maps.put(arr[i], 1);
            }
        }

        //2. NGF함수 : 오른쪽 등장 F함수값이 더 큰수중 가장 왼쪽 수  적는 배열
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i >= 0 ; i--){
            while (!stack.isEmpty() && maps.get(arr[stack.peek()]) <= maps.get(arr[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int v : answer){
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }
}