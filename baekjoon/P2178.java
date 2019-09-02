package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;

public class P2178 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], false);
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int count = 0;
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(0, 0, 1));
		visit[0][0] = true;
		while (true) {
			Point p = queue.poll();
			if (p.x == N-1 && p.y == M-1) {
				count = p.dist;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x >= 0 && y >= 0 && x < N && y < M) {
					if (map[x][y] == 1 && !visit[x][y]) {
						queue.offer(new Point(x, y, p.dist + 1));
						visit[x][y] = true;
					}
				}
			}
		}
		
		return count;
	}
}

class Point {
	int x;
	int y;
	int dist;
	Point(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
