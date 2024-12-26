package old.week1.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass {
  public static void main(String[] args) {
    Queue<String> queue = new LinkedList<>();
    queue.offer("h");
    queue.offer("a");
    queue.offer("k");

    System.out.println(queue.peek()); //k
    System.out.println(queue.size()); //3
    System.out.println(queue.poll());//h
    System.out.println(queue.size()); //2

  }
}
