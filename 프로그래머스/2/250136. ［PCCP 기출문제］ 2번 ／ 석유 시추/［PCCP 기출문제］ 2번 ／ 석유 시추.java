import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<Integer>[] list;
    static boolean[][] visit;
    static int col, row;
    static int[] dx = {0,-1,1,0};
    static int[] dy = {1,0,0,-1};
    
    public int solution(int[][] land) {
        col = land.length;
        row = land[0].length;
        int answer = 0;
        //시추 정보 담기
        list = new ArrayList[row];
        for(int i = 0; i<row; i++)
            list[i] = new ArrayList<>();
        
        //방문 2차원 배열 초기화
        visit = new boolean[col][];
        for(int i = 0; i < col; i++){
            visit[i] = new boolean[row];
            Arrays.fill(visit[i], false);
        }
        //먼저 양을 Land에 반영
        Queue<int[]> queue = new LinkedList<>();
        
        for (int xa=0; xa<col; xa++){
            for(int ya=0; ya<row; ya++){
           
                if (land[xa][ya] == 1 && ! visit[xa][ya]){
                    Set<Integer> cols = new HashSet<>();
                    queue.add(new int[] {xa, ya});
                    int count = 0;
                    
                    while(!queue.isEmpty()){
                        int[] pop = queue.poll();
                        int x = pop[0];
                        int y = pop[1];
                        
                        visit[x][y] = true;
                        count++;

                        for(int i = 0;i< 4; i++){
                            
                            int newx = x + dx[i];
                            int newy = y + dy[i];
                            
                            if (isnotok(newx , newy)) continue;

                            if (land[newx][newy] == 1 && !visit[newx][newy]) 
                            {
                                visit[newx][newy] = true;
                                queue.add(new int[]{newx, newy});
                            }
                            cols.add(y);

                        }
                        
                            
                    }
                    for (int c : cols) {
                        list[c].add(count);
                    }
                }
               
                
                
            }
        }
        /*
        //디버깅
        for(int i = 0 ; i < row; i++){
            ArrayList<Integer> arr = list[i];
            for(int j = 0; j < arr.size() ; j++)
                System.out.println(arr.get(j));
        }
        */
        
        //y위치 시추마다 max값 (answer) 계산
        
        for(int i = 0 ; i < row ; i++){
            int sum = list[i]
              .stream()
              .mapToInt(Integer::intValue)
              .sum();
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    
    private static boolean isnotok(int x, int y){
        return x < 0 || y < 0 || x >= col || y >= row;
    }
        
        
}