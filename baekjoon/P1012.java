package baekjoon;
import java.io.*;
import java.util.*;

public class P1012 {
	static int[][] arr = new int[50][50];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T > 0) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				Arrays.fill(arr[i], 0);
			}
			
			for (int i = 0; i < K; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						bfs(M, N, i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
			T--;
		}
	}
	
	public static void dfs(int M, int N, int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
				if (arr[nextX][nextY] == 1) {
					arr[nextX][nextY] = 0;
					dfs(M, N, nextX, nextY);
				}
			}
		}
	}
	
	public static void bfs(int M, int N, int x, int y) {
		Queue<Position> queue = new LinkedList<Position>();
		queue.offer(new Position(x, y));
		
		while (!queue.isEmpty()) {
			Position p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				
				if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N) {
					if (arr[nextX][nextY] == 1) {
						arr[nextX][nextY] = 0;
						queue.offer(new Position(nextX, nextY));
					}
				}
			}
		}
	}
}
