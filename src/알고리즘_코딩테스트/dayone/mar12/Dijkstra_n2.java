package 알고리즘_코딩테스트.dayone.mar12;

import java.util.ArrayList;
import java.util.Scanner;


public class Dijkstra_n2 {
    public static void main(String[] args){
        class Node{
            int idx;
            int cost;

            Node(int idx, int cost){
                this.idx = idx;
                this.cost = cost;
            }
        }
        Scanner sc = new Scanner(System.in);
        //노드와 간선의 개수
        int v = sc.nextInt();
        int e = sc.nextInt();
        //출발지점
        int start = sc.nextInt();

        //1.인접리스트를 이용한 그래프 초기화
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        //노드의 번호가 1부터 시작하므로 0번 인덱스 부분을 임의로 만들어 놓기만 한다
        for (int i = 0 ; i < v+1 ; i++){
            graph.add(new ArrayList<>());
        }
        //그래프에 값을 넣는다
        for (int i = 0 ; i <e ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(a).add(new Node(b, cost));
        }
        //방문 여부를 확인할 boolean배열, start노드부터 end 노드까지의 최소거리를 저장할 배열을 만든다
        boolean[] visited = new boolean[v+1];
        int[] dist = new int[v+1];

        //3.최소 거리 정보를 담을 배열을 초기화
        for (int i = 0 ; i < v +1 ;i ++){
            //출발 지점 외 나머지 지점까지의 최소 비용은 최대로 저장
            dist[i] = Integer.MAX_VALUE;
        }
        //출발 지점의 비용은 0으로 시작
        dist[start] = 0;

        //4.다익스트라 알고리즘 진행
        //모든 노드를 방문하면 종료하기 때문에 노드의 개수만큼만 반복을 한다
        for (int i = 0 ; i < v; i++){
            //4-1.현재 거리 비용 중 최소인 지점을 선택
            //해당 노드가 가지고 있는 현재 비용
            int nodeValue = Integer.MAX_VALUE;
            //해당 노드의 인덱스(번호)
            int nodeIdx = 0;
            //인덱스 0은 생각하지 않기 때문에 0부터 반복을 진행한다
            for (int j = 1;  j < v+1 ; j++){
                //해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다
                if (!visited[j] && dist[j] < nodeValue){
                    nodeValue = dist[j];
                    nodeIdx = j;//start노드가 선택됨 ( 처음 )
                }
            }
            //최종 선택된 노드를 방문처리 한다
            visited[nodeIdx] = true;
            //4-2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신
            for (int j = 0 ; j < graph.get(nodeIdx).size(); j++){
                //인접 노드를 선택
                Node adjNode = graph.get(nodeIdx).get(j);
                if (dist[adjNode.idx] > dist[nodeIdx] + adjNode.cost){
                    dist[adjNode.idx] = dist[nodeIdx] + adjNode.cost;
                }
            }
        }//end 4

        //5.최소 비용을 출력
        for (int i =1 ; i < v+1 ; i++){
            if (dist[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(dist[i]);
            }
        }
        sc.close();
    }
}
