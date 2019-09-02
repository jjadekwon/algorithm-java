package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1992 {
	public static int[][] arr;
	public static String result = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		quard(0, 0, N);
		
		System.out.println(result);
		
		br.close();
	}
	
	public static void quard(int x, int y, int k) {
		boolean div = false;
		for (int i = x; i < x + k; i++) {
			for (int j = y; j < y + k; j++) {
				if (arr[i][j] != arr[x][y]) {
					div = true;
					break;
				}
			}
			if (div) break;
		}
		
		if (div) {
			result += "(";
			quard(x, y, k / 2);
			quard(x, y + k / 2, k / 2);
			quard(x + k / 2, y, k / 2);
			quard(x + k / 2, y + k / 2, k / 2);
			result += ")";
		}
		else {
			result += arr[x][y];
		}
	}
}
