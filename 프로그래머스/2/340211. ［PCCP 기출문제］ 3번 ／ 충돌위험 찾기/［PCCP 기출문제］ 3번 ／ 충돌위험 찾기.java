import java.io.*;
import java.util.*;


class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
    
        ArrayList<int[]>[] pos = new ArrayList[routes.length];
        for(int i = 0 ; i < routes.length; i++){
            pos[i] = new ArrayList<>();
        }
        
        //pos에 points 복사
        for(int i=0;i < routes.length; i++){
            int start = routes[i][0];
            int[] start_point = points[start - 1];
            int[] cur = new int[]{start_point[0], start_point[1]};
            pos[i].add(new int[]{cur[0], cur[1]});
            
         
            for (int r = 1; r < routes[i].length; r++) {
                int[] next = points[routes[i][r] - 1];

                //x 이동
                while (cur[0] != next[0]) {
                    cur[0] += cur[0] < next[0] ? 1 : -1;
                    pos[i].add(new int[]{cur[0], cur[1]});
                }

                //y 이동
                while (cur[1] != next[1]) {
                    cur[1] += cur[1] < next[1] ? 1 : -1;
                    pos[i].add(new int[]{cur[0], cur[1]});
                }
            }
  
        }
        //디버깅용
        /*
        for (int i = 0 ; i < pos.length; i++){
            ArrayList<int[]> list = pos[i];
            for (int[]  t : list){
                System.out.print("[" + t[0] + " , " + t[1] +"] ");
            }
            System.out.println();
        }
        */
        
        //pos에서 위치 같은거 answer++
        int maxTime = 0;
        for (int i = 0; i < routes.length; i++) {
            maxTime = Math.max(maxTime, pos[i].size());
        }

        
        for (int t = 0; t < maxTime; t++) {
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < routes.length; i++) {
        if (t < pos[i].size()) {
            int[] p = pos[i].get(t);
            String key = p[0] + "," + p[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }

    for (int v : map.values()) {
        if (v >= 2) answer++;
    }
}

        
        return answer;
    }
    /*
    private static void put(int x, ArrayList<int[]> pos, int abs, boolean check, int[] curPoint){//x == 1 : x가 변화, check : 변화 < 0
        
        if (x == 1){
            while(abs != 0){
                if (check == true ){
                    pos.add(new int[] {curPoint[0] - 1, curPoint[1]});
                    abs--;
                    curPoint[0] = curPoint[0] - 1;
                }else{
                    pos.add(new int[] {curPoint[0] + 1, curPoint[1]});
                    abs--;
                    curPoint[0] = curPoint[0] + 1;
                }
            }
        }else{
            while(abs != 0){
                if (check == true){
                    pos.add(new int[] {curPoint[0], curPoint[1] - 1});
                    abs--;
                    curPoint[1] = curPoint[1] - 1;
                }else{
                    pos.add(new int[] {curPoint[0], curPoint[1] + 1});
                    abs--;
                    curPoint[1] = curPoint[1] + 1;
                }
            }
            
        }
    }*/
}
//3 + 1 + 2 + 2 + 1 0초와 목적지에 도착한 시점에도 세기