import java.io.*;
import java.util.*;
 
public class Main {
    static int M, N;
	
    static int[][] map;
    static int[][] dp;
	
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        M = Integer.parseInt(st.nextToken()); // 세로
        N = Integer.parseInt(st.nextToken()); // 가로
		
        map = new int[M][N];
        dp = new int[M][N];
		
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // dp 초기화
            }
        }
		
        System.out.println(dfs(0, 0)); // 출발 지점 
    }
	public static int dfs(int x, int y) {
        // 도착지점까지 도달했을 경우
        if (x == M-1 && y == N-1) return 1;
		
        // 방문한 적이 없는 경우
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
				
                if (nx < 0 || nx > M-1 || ny < 0 || ny > N-1) continue;
				
                // 내리막 길인 경우
                if (map[x][y] > map[nx][ny]) {
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}