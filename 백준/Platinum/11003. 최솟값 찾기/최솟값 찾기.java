
import java.io.*;
import java.util.*;


public class Main {
  static class Node{
    int index;
    int value;

    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  static int N, L;
  //static int arr[];
  static StringBuilder sb = new StringBuilder();
  static Deque<Node> deque = new ArrayDeque<>();
  public static void main(String[] args) throws IOException {
    input();
    StringTokenizer ts = new StringTokenizer(bf.readLine());

    for (int i = 0 ; i < N; i++){
      int now = Integer.parseInt(ts.nextToken());
      while (!deque.isEmpty() && deque.getLast().value > now){
        deque.removeLast();
      }
      deque.addLast(new Node(i, now));

      if (deque.getFirst().index <= i-L){
        deque.removeFirst();
      }
      sb.append(deque.getFirst().value).append(" ");
    }
    System.out.println(sb);


  }

  static void input() throws IOException {
    StringTokenizer ts = new StringTokenizer(bf.readLine());
    N = Integer.parseInt(ts.nextToken());
    L = Integer.parseInt(ts.nextToken());
//    arr = new int[N];
//    arr = Arrays.stream(bf.readLine().split(" "))
//            .mapToInt(Integer::parseInt)
//            .toArray();

  }
}
