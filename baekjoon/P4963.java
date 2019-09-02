package baekjoon;
import java.io.*;
import java.util.*;

public class P4963 {
	static final int MAX = 50;
	static int[][] map = new int[MAX][MAX];
	static int[] dx = new int[] {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = new int[] {1, 1, 0, -1, -1, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);

			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0) break;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						dfs(w, h, i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
		
		
		br.close();
	}
	
	public static void dfs(int w, int h, int x, int y) {
		for (int i = 0; i < 8; i++) {
			int moveX = x + dx[i];
			int moveY = y + dy[i];
			if (moveX >= 0 && moveX < h && moveY >= 0 && moveY < w) {
				if (map[moveX][moveY] == 1) {
					map[moveX][moveY] = 0;
					dfs(w, h, moveX, moveY);
				}
			}
		}
	}
}
