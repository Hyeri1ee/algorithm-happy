package week2.day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P11724_other {
  static int N,M;
  static int[] parents;

  public static void main(String[] args) throws Exception{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    HashSet<Integer> hs = new HashSet<>();

    StringTokenizer st = new StringTokenizer(bf.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    parents = new int[N+1];

    for (int i = 1; i < parents.length; i++){
      parents[i] = i;
    }
    for(int i=0;i<M;i++) {
      st = new StringTokenizer(bf.readLine());

      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      if(find(u)!=find(v)) union(u,v);

    }

    for(int i=1;i<parents.length;i++) {
      hs.add(find(i));
    }

    System.out.println(hs.size());
  }

  public static void union(int a, int b){
    int aroot = find(a);
    int broot = find(b);

    if (aroot > broot) parents[aroot] = broot;
    else parents[broot] =aroot;
  }

  public static int find(int a){
    if(parents[a]==a) return a;
    return parents[a] = find(parents[a]);
  }
}
