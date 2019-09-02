package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5719 {
	public static int[][] map = new int[500][500];
	public static boolean[] visited = new boolean[500];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 장소 수
		int M = Integer.parseInt(st.nextToken()); // 도로 수
		
		while (N != 0 && M != 0) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // 시작점
			int D = Integer.parseInt(st.nextToken()); // 도착점

			for (int i = 0; i < N; i++) {
				Arrays.fill(map[i], 0);
			}
			
			Arrays.fill(visited, false);
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());

				map[U][V] = map[V][U] = P;
			}
			
			//System.out.println(bfs(N, S, D).get(1));
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
//	public static int dijkstra(int n, int s, int d) {
//		PriorityQueue<Pos> queue = new PriorityQueue<>(Comparator.comparing(p -> p.dist));
//		queue.offer(new Pos(s, 0));
//		visited[s] = true;
//		
//		while (!queue.isEmpty()) {
//			Pos p = queue.poll();
//			for (int i = 0; i < n; i++) {
//				if (map[p.pos][i] != 0 && !visited[i]) {
//					queue.offer(new Pos(i, p.dist + map[p.pos][i]));
//					visited[i] = true;
//				}
//			}
//		}
//		
//		return dist;
//	}
}

class Pos {
	public int pos;
	public int dist;
	public Pos(int pos, int dist) {
		this.pos = pos;
		this.dist = dist;
	}
}
