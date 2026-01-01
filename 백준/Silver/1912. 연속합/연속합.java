import java.io.*;
import java.util.*;

class Main{
    static int n;
    static ArrayList<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        StringTokenizer st =new StringTokenizer(bf.readLine());
        /*
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        */
        //
        //Collections.sort(list, (a,b)-> (b-a)); //내림 정렬
        int localans = Integer.parseInt(st.nextToken());;
        int globalans = localans;
       
        for(int i = 1; i < n ; i++){
            int x = Integer.parseInt(st.nextToken());
            localans = Math.max(x, localans + x);
            globalans = Math.max(localans, globalans);
        }
        
        System.out.println(globalans);
        
    }
}