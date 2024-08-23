package week1.day5;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  public static void main(String [] args) throws Exception{
    int n = Integer.parseInt(bf.readLine());

    for (int i = 0 ;  i < n ; i++){
      String read = bf.readLine();
      String [] arr = read.split(" ");
      StringTokenizer st = new StringTokenizer(bf.readLine());

      int total = Integer.parseInt(arr[0]);
      int location = Integer.parseInt(arr[1]);

      Queue<Integer> que = new LinkedList<>();
      int max = 0;
      for (int j = 0 ; j < total; j++){
         int newOne = Integer.parseInt(st.nextToken());
         max = (max > newOne) ? max : newOne;
         que.offer(newOne);
      }

      int result = 0;
      int theOne = location;
      //이제 몇 번째로 인쇄되는지 보기
      while(! que.isEmpty()){
        int peek = que.peek();
        if (max > peek)
        {//다시 돌아가기
          que.poll();
          que.offer(peek);
          if (theOne == 0)
            theOne += que.size()-1;
          else
            theOne--;
        }
        else { //max == peek
          que.poll();
          theOne--;
          if (theOne == -1){
            result++;
            break;
          }
          result++;
          //max 다시 정하기
          max = 0;
          for (int k = 0 ;  k <que.size() ; k++){
            if (max < que.peek())
              max = que.peek();
            int pe = que.poll();
            que.offer(pe);
          }
        }
      }
      sb.append(Integer.toString(result) + "\n");
    }
    System.out.println(sb);
  }
}
