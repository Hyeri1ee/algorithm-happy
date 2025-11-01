
import java.io.*;
import java.util.*;
/*
2
minji sangdo
daeil 1 hoseok
doha 1 haeun
haeun 0
hoseok 0
minji 3 yuri doha haeun
sangdo 2 hoseok daeil
yuri 0
 */
public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static HashMap<String , Integer> map = new HashMap<>();
    static HashMap<Integer, String> answermap = new HashMap<>();
    static LinkedList<Integer>[] graph;
    static LinkedList<Integer>[] child;
    static int[] d;//진입차수


    //출력에 필요한거
    //int size = sijo.size(); //가문의 개수
    static ArrayList<Integer> sijo = new ArrayList<>();//각 가문의 시조들의 이름 저장 공간
    //graph 를 answermap에 변환해서 출력

    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> queue = new PriorityQueue<>();


    public static void main(String[] args) throws Exception{
        input();

        solve();

        System.out.println(sb);
    }

    private static void print(){

        //출력에 필요한거
        //int size = sijo.size(); //가문의 개수
        //static ArrayList<Integer> sijo = new ArrayList<>();//각 가문의 시조들의 이름 저장 공간
        //graph 를 answermap에 변환해서 출력

        sb.append(sijo.size()).append("\n");
        for(int sijo_num : sijo){
            String sijo_name = answermap.get(sijo_num);
            sb.append(sijo_name).append(" ");
        }

        sb.append("\n");

        for(int i =1; i < child.length; i++){
            String name = answermap.get(i);
            int size = child[i].size();

            Collections.sort(child[i]);

            sb.append(name + " " + size +" ");
            for(int num : child[i]){
                String child_name = answermap.get(num);
                sb.append(child_name +" ");
            }

            sb.append("\n");
        }





    }
    private static void solve(){
        //처음 진입차수 0인 노드 집어 넣기
        for(int i = 1; i < n+1; i++){
            if (d[i] == 0) {
                queue.add(i);
                sijo.add(i);
            }
        }

        Collections.sort(sijo);



        while(!queue.isEmpty()){
            int poll = queue.poll();

            for(int target : graph[poll]){
                d[target]--;
                if (d[target] == 0)
                {
                    queue.add(target);
                    child[poll].add(target);//poll의 자식인데 바로 d[target] ==0이면 직계 자식임
                }
            }
        }

        print();//출력하는 부분
    }

    private static void input() throws Exception{
        n = Integer.parseInt(bf.readLine());
        //st = new StringTokenizer(bf.readLine());
        List<String> list = new ArrayList<>(Arrays.asList(bf.readLine().split(" "))); //사전순 정렬을 위해 처음부터 map, answermap에 1,2,3...순으로 넣기
        Collections.sort(list, (o1, o2) -> {
            return o1.compareTo(o2);
        });
        /*
        //debug용
        for(String s : list){
            System.out.println(s);
        }
         */

        graph = new LinkedList[n+1]; //이거 정의 다시 보기
        child = new LinkedList[n+1];
        d = new int[n+1];


        for(int i =1; i < n+1; i++) {
            graph[i] = new LinkedList<>();
            child[i] = new LinkedList<>();
        }

        for(int i = 0; i < n; i++){
            String name = list.get(i);
            map.put(name, i+1);
            answermap.put(i+1, name);//후에 출력시를 위해
        }

        m = Integer.parseInt(bf.readLine());
        for(int i=1; i< m+1; i++){
            st = new StringTokenizer(bf.readLine());
            String person = st.nextToken();
            int numinmap_person = map.get(person);
            String ancestor = st.nextToken();
            int numinmap_ancestor = map.get(ancestor);


            graph[numinmap_ancestor].add(numinmap_person);
            d[numinmap_person]++;

        }

    }
}
