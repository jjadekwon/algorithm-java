package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13460 {
	static char[][] map = new char[10][10];
	static boolean[][] visited = new boolean[10][10];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < 10; i++) {
			Arrays.fill(map[i], '#');
			Arrays.fill(visited[i], false);
		}

		Queue<Position> redQueue = new LinkedList<Position>();
		Queue<Position> blueQueue = new LinkedList<Position>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
				
				if (map[i][j] == 'R') {
					redQueue.offer(new Position(j, i, 0));
					visited[i][j] = true;
				}
				else if (map[i][j] == 'B') {
					blueQueue.offer(new Position(j, i, 0));
				}
			}
		}

		System.out.println(bfs(redQueue, blueQueue));
		
		br.close();
	}
	
	public static int bfs(Queue<Position> redQueue, Queue<Position> blueQueue) {
		int result = -1;
		while (true) {
			Position red = redQueue.poll();
			Position blue = blueQueue.poll();
			
			if (red == null || blue == null) break;

			if (map[red.y][red.x] == 'O' || red.dist > 10) {
				result = red.dist > 10 ? -1 : red.dist;
				break;
			}
			
			// 상하좌우 이동
			for (int i = 0; i < 4; i++) {
				boolean isFailed = false;	 // 파란 공이 O으로 빠지는 경우
				boolean isSuccessed = false; // 빨간 공이 O으로 빠지는 경우
				
				// 빨간 공 이동
				int nextRedX = red.x;
				int nextRedY = red.y;
				while (true) {
					if (map[nextRedY + dy[i]][nextRedX + dx[i]] == '#') break;
					
					if (map[nextRedY][nextRedX] == 'O') {
						isSuccessed = true;
						break;
					}

					nextRedX += dx[i];
					nextRedY += dy[i];
				}
					
				// 파란 공 이동
				int nextBlueX = blue.x;
				int nextBlueY = blue.y;
				while (true) {
					if (map[nextBlueY + dy[i]][nextBlueX + dx[i]] == '#') break;
					
					if (map[nextBlueY + dy[i]][nextBlueX + dx[i]] == 'O') {
						isFailed = true;
					}

					nextBlueX += dx[i];
					nextBlueY += dy[i];
				}
				
				// 빨간 공이 바로 O으로 빠지는 경우
				if (!isFailed && isSuccessed) {
					blueQueue.offer(new Position(nextBlueX, nextBlueY, blue.dist + 1));
					redQueue.offer(new Position(nextRedX, nextRedY, red.dist + 1));
					break;
				}
				
				if (!isFailed && 
					(red.x != nextRedX || red.y != nextRedY || blue.x != nextBlueX || blue.y != nextBlueY)) {
					// 공 두 개가 겹치는 경우
					if (nextRedX == nextBlueX && nextRedY == nextBlueY) {
						if (red.x > blue.x) {
							if (dx[i] == 1) {
								nextBlueX--;
							}
							else {
								nextRedX++;
							}
						}
						else if (red.x < blue.x) {
							if (dx[i] == 1) {
								nextRedX--;
							}
							else {
								nextBlueX++;
							}
						}
						else if (red.y > blue.y){
							if (dy[i] == 1) {
								nextBlueY--;
							}
							else {
								nextRedY++;
							}
						}
						else {
							if (dy[i] == 1) {
								nextRedY--;
							}
							else {
								nextBlueY++;
							}
						}
					}

					blueQueue.offer(new Position(nextBlueX, nextBlueY, blue.dist + 1));
					redQueue.offer(new Position(nextRedX, nextRedY, red.dist + 1));
				}
			}
		}
		
		return result;
	}
}