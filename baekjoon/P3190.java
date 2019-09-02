package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class P3190 {
	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], 0);
		}
		
		int K = Integer.parseInt(br.readLine());	// 사과 개수
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;
			
			map[row][col] = 1;
		}
	
		int L = Integer.parseInt(br.readLine());	// 뱀의 방향 변환 횟수
		int[] seconds = new int[L];
		char[] dirInfos = new char[L];
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			seconds[i] = Integer.parseInt(st.nextToken());
			dirInfos[i] = st.nextToken().charAt(0);
		}
		
		int dir = 3;	// 오른쪽 이동
		int sec = 0;
		Deque<Position> deque = new ArrayDeque<>();
		deque.offer(new Position(0, 0));
		while (true) {
			sec++;
			
			Position curr = deque.peekLast();
			int nextX = curr.x + dx[dir];
			int nextY = curr.y + dy[dir];
			
			Position next = new Position(nextX, nextY);
			if ((nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) ||
				(deque.contains(next))) {
				break;
			}
			
			deque.offer(next);
			
			// 사과가 없는 경우
			if (map[nextY][nextX] == 0) {
				// 꼬리 삭제
				deque.poll();
			}
			else {
				// 사과 먹음
				map[nextY][nextX] = 0;
			}

			// 회전
			for (int i = 0; i < L; i++) {
				if (sec == seconds[i]) {
					dir = rotate(dir, dirInfos[i]);
					break;
				}
			}
		}
		
		System.out.println(sec);
		
		br.close();
	}
	
	public static int rotate(int currDir, char rotation) {
		int dir = currDir;
		
		// 왼쪽으로 회전
		if (rotation == 'L') {
			switch (currDir) {
				case 0: dir = 2; break;
				case 1: dir = 3; break;
				case 2: dir = 1; break;
				case 3: dir = 0; break;
			}
		}
		
		// 오른쪽으로 회전
		else {
			switch (currDir) {
				case 0: dir = 3; break;
				case 1: dir = 2; break;
				case 2: dir = 0; break;
				case 3: dir = 1; break;
			}
		}
		
		return dir;
	}
}

class Position {
	int x;
	int y;
	int dist;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Position(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	 
	public boolean equals(Object o) {
		Position p = (Position)o;
		if (this.x == p.x && this.y == p.y) return true;
		return false;
	}
}
