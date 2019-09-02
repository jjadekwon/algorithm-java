package baekjoon;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class P2667 {
	static int N;
	static int[][] arr;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static LinkedList<Integer> countList = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 1인 것 찾기
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					// 0 추가
					countList.add(0);
					dfs(index++, i, j);
				}
			}
		}

		Collections.sort(countList);
		
		// 단지 수
		int count = countList.size();
		System.out.println(count);
		
		for (int i = 0; i < count; i++) {
			System.out.println(countList.get(i));
		}
	}
	
	public static void dfs(int index, int x, int y) {
		arr[x][y] = 0;
		countList.set(index, countList.get(index) + 1);
		
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
				if (arr[nextX][nextY] == 1) {
					dfs(index, nextX, nextY);
				}
			}
		}
	}
}
