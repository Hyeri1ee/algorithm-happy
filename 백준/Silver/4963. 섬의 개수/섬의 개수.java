import java.util.*;
import java.io.*;

public class Main {
	static int arr[][];
	static boolean visit[][];
	static int dirX[] = {0, 0, -1 ,1, -1, 1, -1, 1}; // 상좌, 상우, 하좌, 하우
	static int dirY[] = {-1, 1, 0, 0, 1, 1, -1, -1}; // 상 하 좌 우 대각선 상좌, 상우, 하좌, 하우

	static int w, h, nowX, nowY;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = " ";
		while( !(str = br.readLine()).equals("0 0") ) {
			st = new StringTokenizer(str);
	

			w = Integer.parseInt(st.nextToken()); 
			h = Integer.parseInt(st.nextToken()); 
			arr = new int[h][w];
			visit = new boolean[h][w];

			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());

				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
	
				}
}

			int island_count = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {

					if(!visit[i][j] && arr[i][j] == 1){
						island_count++;
						DFS(i, j);
					}
				}
			} 

			sb.append(island_count).append('\n');
		}

		System.out.println(sb);
	} // End of main

	static void DFS(int x, int y) {
		visit[x][y] = true;

		for(int i=0; i<8; i++) {
			nowX = dirX[i] + x;
			nowY = dirY[i] + y;

			if(range_check() && !visit[nowX][nowY] && arr[nowX][nowY] == 1) {
				DFS(nowX, nowY);
			}
		}

	} // End of DFS

	static boolean range_check() {
		return (nowX >= 0 && nowY >= 0 && nowX < h && nowY < w);
	} // End of range_check

}