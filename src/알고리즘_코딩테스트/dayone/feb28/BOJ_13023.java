package 알고리즘_코딩테스트.dayone.feb28;

import java.util.*;
import java.io.*;

public class BOJ_13023 {
    /*
    n명이 참가하고 있는데, 5명의 노드가 연결된 경우가 있으면 1출력, 없으면 0 출력
     */
    static BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    static int n,e;
    static int[] visited;
    static boolean found = false;


    public static void main(String[] args) throws IOException{
        ArrayList<Integer>[] edge;
        //n,e 노드, 에지 개수 입력 받기 - 링크드리스트, visited[] 체크 배열 정의
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        edge = new ArrayList[n];
        for (int i = 0 ; i  < n; i++){
            edge[i] = new ArrayList<>();
        }
        visited = new int[n];

        // for 문으로 이어진 각 노드 값 입력 받기
        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(bf.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edge[node1].add(node2);
            edge[node2].add(node1);
        }

        //dfs 함수로 탐방해서 group = 5가 되면 1 출력
        for (int i= 0; i< n;i++){
            dfs(i, edge, 1);
            if (found)
                break;
        }

        if (found)
            System.out.println(1);
        else
            System.out.println(0);

    }
    private static void dfs(int s, ArrayList<Integer>[] edge, int group){
        if (found) return; // 이미 찾았으면 더 이상 탐색하지 않음

        if (group == 5) {
            found = true;
            return;
        }

        visited[s] = 1; // 방문함을 체크

        for (int next : edge[s]) {
            if (visited[next] == 0) { // 방문하지 않은 곳이면
                dfs(next, edge, group + 1);
            }
        }

        visited[s] = 0;
    }
}
