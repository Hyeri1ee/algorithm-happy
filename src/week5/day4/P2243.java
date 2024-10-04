//package week5.day4;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
///*
//A B : 1 _
//사탕을 꺼내는 경우, B는 꺼낼 사탕의 순위 -> 사탕이 1개 꺼내짐
//A B C : 2 _ _
//사탕을 넣는 경우, B는 넣을 사탕의 맛을 나타내는 정수, C는 그러한 사탕의 개수
//
// */
//public class P2243 {
//  static long[] tree;
//  static int n;
//  static int S;
//
//  static StringBuilder sb = new StringBuilder();
//
//  public static void main(String[] args) throws Exception{
//    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//    n = Integer.parseInt(bf.readLine());
//
//    S = 1;
//    while(S < 1000000)
//      S *= 2;
//    tree = new long[S * 2];
//
//    for (int i = 0 ; i < n ; i++){
//      StringTokenizer st = new StringTokenizer(bf.readLine());
//      int A = Integer.parseInt(st.nextToken());
//      if (A == 2){//사탕을 넣는 경우
//        long B = Integer.parseInt(st.nextToken());
//        long C = Integer.parseInt(st.nextToken());
//        //update(1,S,B,C);
//      }
//      else {//A == 1인 경우 = 사탕을 가져가는 경우
//        long B = Integer.parseInt(st.nextToken());
//        sb.append(query(1,S,1,B));
//        sb.append("\n");
//      }
//    }//end of for
//
//    System.out.println(sb);
//
//  }//end of main
//
//  private static long query(int left, long right, long node, long rank){
//    if (left == right){
//      update(1, S, 1, left, -1);
//      return left;
//    }
//    long mid = (left + right) / 2;
//    if (tree[(int) node * 2] >= rank){
//      return query(left, mid, node * 2, rank);
//    }else{
//      //return query(mid+1, right, node*2+1, rank - tree[node*2]);
//    }
//  }
//
//  private static void update(long left, long right, int node, long target, long num){
//    if (target < left || right < target){
//      return;
//    }else{
//      tree[node] += num; //구간합 또한 증가/감소
//      if (left != right){
//        long mid = (left + right) / 2;
//        update(left, mid, node *2, target, num);
//        update(mid+1, right, node*2+1, target, num);
//      }
//    }
//  }
//
//
//
//}
//
