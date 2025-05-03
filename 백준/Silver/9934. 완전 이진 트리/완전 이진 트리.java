import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int K, size;
    static int[] num;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        size = (int)(Math.pow(2, K) - 1);
        tree = new ArrayList[K+1];
        num = new int[size+1];
        for(int i=0;i<=K;i++)
            tree[i] = new ArrayList<>();
        int index = 1;
        while(st.hasMoreTokens())
            num[index++] = Integer.parseInt(st.nextToken());
        search(1, 1, size);		
        for(int i=1;i<=K;i++){
            for(int j=0;j<tree[i].size();j++)
                bw.write(tree[i].get(j) + " ");
            bw.newLine();
        }
        bw.flush();	
        bw.close();
        br.close();
    }
    static void search(int depth, int start, int end){
        int mid = (start + end)/2;	
        tree[depth].add(num[mid]);
        if(depth == K)		//8
            return;
        search(depth+1, start, mid-1);
        search(depth+1, mid+1, end);
    }
}