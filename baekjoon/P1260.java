package baekjoon;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class P1260 {
	static int map[][];
	static boolean visit[];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i = 0; i <= N; i++) {
			Arrays.fill(map[i], 0);
		}
		
		Arrays.fill(visit, false);
		
		for (int i = 0; i < M; i++) {
			String edge = br.readLine();
			st = new StringTokenizer(edge);

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			map[v1][v2] = map[v2][v1] = 1;
		}

		dfs(V);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(V);
	}
	
	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(v);
		visit[v] = true;
		System.out.printf(v + " ");
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (map[poll][i] == 1 && !visit[i]) {
					queue.offer(i);
					visit[i] = true;
					System.out.printf(i + " ");
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1 && !visit[i]) {
				bfs(i);
			}
		}
	}
	
	public static void dfs(int v) {
		visit[v] = true;
		System.out.printf(v + " ");
		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}
}
