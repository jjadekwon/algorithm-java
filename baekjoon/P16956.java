package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16956 {
	static int R, C;
	static char[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		
		if (canGo()) {
			System.out.println(0);
		}
		else {
			System.out.println(1);
			
			// 울타리 막기 -- 다 D로 채우면 됨
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					char print = map[i][j] == '.' ? 'D' : map[i][j];
					System.out.print(print);
				}
				System.out.println();
			}
		}
	}
	
	public static boolean canGo() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					for (int k = 0; k < 4; k++) {
						int moveX = i + dx[k];
						int moveY = j + dy[k];
						if (moveX >= 0 && moveX < R && moveY >= 0 && moveY < C) {
							if (map[moveX][moveY] == 'W') return true;
						}
					}
				}
			}
		}
		
		return false;
	}
}
