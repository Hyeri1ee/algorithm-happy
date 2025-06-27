import java.util.*;
import java.io.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};//상하좌우
    int[] dy = {0,0,-1,1};
    boolean[][] visited;
    int row, col;
    
    //아무 섬도 없는 경우
    int[] nothing = {-1};
    
    public int[] solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        visited = new boolean[row][col];        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && maps[i].charAt(j) != 'X') {
                    int foodSum = dfs(maps, i, j);
                    answerList.add(foodSum);
                }
            }
        }
        
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(answer);//오름차순 정리
        return (answer.length > 0 ) ? answer : nothing;
    }
    
    public int dfs(String[] maps, int x, int y){
        visited[x][y] = true;
        int sum = maps[x].charAt(y) - '0'; // 문자 → 숫자 변환

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    sum += dfs(maps, nx, ny);
                }
            }
        }

        return sum;
        
    }
}
