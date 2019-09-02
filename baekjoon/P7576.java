package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

public class P7576 {
	static int M, N;
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], false);
		}

		arr = new int[N][M];
		boolean ripen = true;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] == 0) ripen = false;
			}
		}

		// ��� �;��ִ� ���
		if (ripen) {
			System.out.println(0);
		}
		else {
			System.out.println(bfs());
		}
	}
	
	public static int bfs() {
		Queue<Position> queue = new LinkedList<Position>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++ ) {
				if (arr[i][j] == 1) {
					queue.offer(new Position(i, j));
					visit[i][j] = true;
				}
			}
		}
		
		int day = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Position next = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = next.x + dx[j];
					int y = next.y + dy[j];
					if (x >= 0 && x < N && y >= 0 && y < M) {
						if (arr[x][y] == 0 && !visit[x][y]) {
							queue.offer(new Position(x, y));
							arr[x][y] = 1;
							visit[x][y] = true;
						}
					}
				}
			}
			day++;
		}
		
		boolean ripen = true;
		
		// �� �;����� üũ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					ripen = false;
				}
			}
		}
		
		if (ripen) return day - 1;
		
		return -1;
	}
}