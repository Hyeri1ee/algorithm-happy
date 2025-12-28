//
import java.io.*;
import java.util.*;

class Main{
    static int n, m;
    static int[] arr, tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //n
        n = Integer.parseInt(bf.readLine());
        arr = new int[n+1];
        tree = new int[n * 4];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i =1; i<= n ;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //m
        m = Integer.parseInt(bf.readLine());
        
        init(1, 1, n);
        
        for(int i =0 ; i < m;i ++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a == 1){
                update(1, 1, n, b, c);
            }
            else if (a == 2){
                int res = query(1, 1, n, b, c);
                sb.append(res).append("\n");
            }else{
                int res = query(1, 1, n, b, c);
                sb.append( ( c-b+1) - res).append("\n");
            }
        }
        
        //출력
        System.out.println(sb);
    }
    
    //초기화
    public static int init(int node, int start, int end){
        if (start == end){
            return tree[node] = (arr[start] % 2 == 0) ?  1 : 0;
        }
        
        int mid = (start+end)/2;
        int l = init(node * 2 , start, mid);
        int r = init(node * 2 + 1 , mid+1, end);
        
        return tree[node] = l+r;
        
    }
    //query
    public static int query(int node, int start, int end, int left, int right){
        if (left > end || right < start){
            return 0;
        }
        
        if (left <= start && end <= right){
            return tree[node];
        }
        int mid = (start+end)/2;
        
        int l = query(node * 2 , start, mid, left, right);
        int r = query(node * 2 + 1 , mid+1, end, left, right);
        
        return l+r;
    }
    
    //update
    public static void update(int node, int start, int end, int idx, int val){
        if (idx< start || idx > end) return;
        
        int mid = (start+end)/2;
        //tree[node] += val - arr[idx];
        if (start==end) {
            arr[idx] = val;
            tree[node] = (val % 2 == 0) ? 1 : 0;
            return;
        }
        update(node * 2, start, mid, idx, val);
        update(node*2 + 1, mid+1, end, idx, val);
        //업데이트!!!!!
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}