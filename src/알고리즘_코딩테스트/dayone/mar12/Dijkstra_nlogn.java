package 알고리즘_코딩테스트.dayone.mar12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra_nlogn {
    static int v, e, start;
    static ArrayList<ArrayList<Node>> graph;

    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        //초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        graph = new ArrayList<ArrayList<Node>>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, c));
        }

        //다익스트라 알고리즘 초기화
        int[] dist = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        //가장 작은 비용을 가진 노드 선택 자동화 -> 우선순위 큐
        PriorityQueue<Node> q = new PriorityQueue<Node>((o1,o2) -> Integer.compare(o1.cost,o2.cost));
        q.offer(new Node(start, 0));
        dist[start] = 0;
        while(!q.isEmpty()){
            Node  curNode = q.poll();
            //꺼낸 노드 = 현재 최소 비용을 갖는 노드
            //즉, 해당 노드의 비용이 현재 dist배열에 기록된 내용보다 크다면 고려할 필요가 없음
            if (dist[curNode.idx] < curNode.cost){
                continue;
            }

            //선택된 노드의 모든 주변 노드를 고려
            for(int i = 0 ; i < graph.get(curNode.idx).size(); i++){
                Node nxtNode = graph.get(curNode.idx).get(i);
                if (dist[nxtNode.idx] > curNode.cost + nxtNode.cost) {
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    // 갱신된 경우에만 큐에 넣는다.
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }
}
