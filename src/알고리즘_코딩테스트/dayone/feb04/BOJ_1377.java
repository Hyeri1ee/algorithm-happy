package 알고리즘_코딩테스트.dayone.feb04;

import java.util.*;
import java.io.*;
class Group{
  int index;
  int value;

  public Group(int index, int value) {
    this.index = index;
    this.value = value;
  }
}

public class BOJ_1377 {
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  public static void main(String[] args) throws IOException {
    // 초기화
    int n = Integer.parseInt(bf.readLine());
    Group [] first = new Group[n];

    for (int i = 0 ; i < n ; i++){
      int value = Integer.parseInt(bf.readLine());
      int index = i;

      first[i] = new Group(index, value);
    }

    // sort
    Arrays.sort(first, new Comparator<Group>() {
      @Override
      public int compare(Group o1, Group o2) {
        return o1.value - o2.value;
      }
    });

    int max = 0;
    for (int i = 0 ; i < n; i++){
      if (max < first[i].index - i)
        max = first[i].index - i;
    }

    System.out.println(max + 1);
  }
}
