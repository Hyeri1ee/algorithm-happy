package week2.day3;
import java.util.*;
import java.io.*;
public class P11724 {
  static BufferedReader bf =  new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int[][] e;
  static boolean[] visited;
  static int n;

  static LinkedList<Integer> [] array;

  public static void main(String[] args) throws Exception{
    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    e = new int[n+1][n+1];
    for (int i=0 ; i<= n ;i++){
      e[i] = new int[n+1];
    }
    visited = new boolean[n+1];
    for (int i =1; i<= m; i++){
      st = new StringTokenizer(bf.readLine());
      int v1 = Integer.parseInt(st.nextToken());
      int v2 = Integer.parseInt(st.nextToken());
      e[v1][v2] = 1;
      e[v2][v1] = 1;
    }
    array = new LinkedList[n+1];

    int count = 0;
    for (int i = 1 ; i<= n; i++){
      if (array[i] == null) {
        array[i] = new LinkedList<>();
      }

      if (!visited[i]) {
        dfs_count(array[i], i);
        count++;
      }
    }


    System.out.println(count);

  }

  private static void dfs_count(LinkedList<Integer> arr,int i) {
    Stack<Integer> stack = new Stack<>();
    stack.push(i);
    visited[i] = true;
    arr.add(i);
    while(!stack.isEmpty()){
      int top = stack.peek();
      boolean flag = false;
      for (int k =1;  k<= n; k++){
        if (!visited[k] && e[top][k]==1)
        {
          stack.push(k);
          visited[k] = true;
          arr.add(k);
          flag = true;
          break;
        }
      }
      if (!flag){
        stack.pop();
      }
    }
  }
}
