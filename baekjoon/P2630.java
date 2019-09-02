package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2630 {
	public static int N;
	public static int[][] arr;
	public static int blue, white;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		blue = white = 0;
		
		quardrisect(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);

        br.close();
	}
	 
	public static void quardrisect(int x, int y, int k) {
		boolean div = false;
		int tempBlue = 0;
		int tempWhite = 0;
		for (int i = x; i < x + k; i++) {
			for (int j = y; j < y + k; j++) {
				if (arr[i][j] == 0) tempWhite++;
				else tempBlue++;	
			}

			if (tempBlue != 0 && tempWhite != 0) {
				div = true;
				break;
			}
		}
		
		// 4등분
		if (div) {
			quardrisect(x, y, k / 2);
			quardrisect(x + k / 2, y, k / 2);
			quardrisect(x, y + k / 2, k / 2);
			quardrisect(x + k / 2, y + k / 2, k / 2);
		}
		// 모두 하얀색이거나 파란색인 경우
		else {
			if (tempWhite > 0) white++;
			else blue++;
		}
	}
}
