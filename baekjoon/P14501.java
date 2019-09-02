package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] schedule = new int[2][N];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			schedule[0][i] = T;
			schedule[1][i] = P;

			int sum = 0;
			// 현재 지점까지 최대 이익
			for (int j = 0; j < i; j++) {
				if (j + schedule[0][j] <= i) {
					sum = sum < schedule[1][j] ? schedule[1][j] : sum;
				}
			}
			schedule[1][i] = P + sum;

			// 최대 이익
			if (i + T <= N) {
				max = max < schedule[1][i] ? schedule[1][i] : max;
			}
		}
		
		System.out.println(max);
		
		br.close();
	}
}
