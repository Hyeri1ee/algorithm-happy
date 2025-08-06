
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] array;

    static int[] sorted;
    static ArrayList<Deque<Integer>> dequelist = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        input();

        solve();

    }

    private static void solve(){
        HashMap<Integer, Integer> maps = new HashMap<>();
        //sorted 내 값, sorted에서 인덱스

        //maps 정의
        for(int i = 0 ; i < sorted.length; i++){
            maps.put(sorted[i], i);
        }

        ArrayList<Deque> dequeList = new ArrayList<>();

        for(int i = 0 ; i < array.length; i++){//array에서 i번째 원소
            if (i == 0){
                Deque<Integer> newDeque = new ArrayDeque<>();
                newDeque.addFirst(array[i]);
                dequeList.add(newDeque);
                continue;
            }

            //i가 0이 아닌 경우
            int targetIndex = maps.get(array[i]);
            int size = dequeList.size();//데크가 추가되는 경우 무한루프 막기 위해 변수 선언

            for(int j = 0 ; j < size; j++){//j는 dequeList의 j번째 덱
                Deque<Integer> deque = dequeList.get(j);
                int front = deque.getFirst();
                int back = deque.getLast();

                int fronIndex = maps.get(front);
                int backIndex = maps.get(back);


                //해당 j번째 데크에서
                if (Math.abs(fronIndex - targetIndex) == 1) //맨 앞에 넣는 경우
                {
                    deque.addFirst(array[i]);
                    break;
                }

                else if (Math.abs(backIndex - targetIndex) == 1) //맨 뒤에 넣는 경우
                {
                    deque.addLast(array[i]);
                    break;
                }

                else if (j == size - 1)//새로 데크를 만드는 경우
                {
                    Deque<Integer> newDeque1 = new ArrayDeque<>();
                    newDeque1.add(array[i]);
                    dequeList.add(newDeque1);
                    break;
                }
            }
        }


        //dequelist 크기 출력
        System.out.println(dequeList.size());
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n= stoi(bf.readLine());
        array = new int[n];

        for(int i=0;i<n;i++){
            array[i] = stoi(bf.readLine());
        }

        sorted = Arrays.copyOf(array, n);
        Arrays.sort(sorted); //정렬

    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }

}