/*
[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
(0,0), (1,1), (
       (0,1)
*/
import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[][] maxsum = new int[triangle.length][];
        for(int i = 0; i < maxsum.length; i++){
            maxsum[i] = new int[triangle[i].length];
        }
        
        maxsum[0][0] = triangle[0][0];
        
        for(int i = 1; i < maxsum.length; i++){
            for(int j =0; j< maxsum[i].length; j++){
                if (isEdge(maxsum, i, j)){
                    int secondIdx = (j-1) < 0 ? j : j-1;
                    maxsum[i][j] = maxsum[i-1][secondIdx] + triangle[i][j];//갱신
                }else{//is not in the edge ! -> 두 개값 비교해야함
                    maxsum[i][j] = Math.max(maxsum[i-1][j], maxsum[i-1][j-1]) + triangle[i][j];//오른쪽 vs 왼쪽
                }
            }
        }//end of for
        
        //최대값 구하기
        int max = 0;
        int row = maxsum.length-1;
        for(int i=0;i<maxsum[row].length; i++){
            max = Math.max(max, maxsum[row][i]);
        }
        return max;
    }
    
    private static boolean isEdge(int[][] maxsum, int x, int y){
        if (y == 0)//왼쪽 끝
            return true;
        //오른쪽 끝
        if (maxsum[x].length -1 == y)
            return true;
        
        return false;
        
    }
}