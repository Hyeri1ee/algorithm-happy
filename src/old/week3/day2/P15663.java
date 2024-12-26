package old.week3.day2;

import java.util.*;
import java.io.*;

public class P15663{
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static HashSet<String> answerSet = new LinkedHashSet<>();
  static int n,m;
  static int[] arr;//n개의 자연수를 담는 배열 저장소
  static int [] makeArr;//한개 배열 만든 것 저장소
  static boolean [] visited;

  public static void main(String [] args) throws Exception{

    StringTokenizer st = new StringTokenizer(bf.readLine());
    n = Integer.parseInt(st.nextToken()); //n개의 자연수
    m =  Integer.parseInt(st.nextToken()); //m개를 고르기
    st = new StringTokenizer(bf.readLine());
    visited = new boolean [n]; //방문했는지 확인하는 배열
    makeArr = new int[m];
    arr = new int[n];
    for (int i = 0; i< n;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }//end of for

    Arrays.sort(arr);
    dfs(0);
    //sb에 answerSet 값을 넣기
    Iterator iter = answerSet.iterator();
    while(iter.hasNext()){
      sb.append(iter.next()+"\n");
    }
    System.out.println(sb);

  }//end of main

  public static void dfs(int depth) {
    if (depth == m) {//배열의 길이가 m이 되었을때
      String temp = "";
      for (int i = 0; i < m; i++) {
        temp += makeArr[i] + " "; //문자열을 새로 만들어서 hashset에 넣기
      }
      answerSet.add(temp);
      return;
    } else {//배열의 길이가 m보다 작을때
      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          visited[i] = true;
          makeArr[depth] = arr[i];
          dfs(depth + 1);//배열의 길이가 depth+1 이 되었을때
          visited[i] = false;//이전 상태로 돌아가기 위해 대신 i 는 1값 증가
        }
      }
    }
  }





}//end of outer class
