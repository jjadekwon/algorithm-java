package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			for (int j = 0; j <= i; j++) {
				int num = Integer.parseInt(st.nextToken());
				dp[i][j] = num;
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] += dp[i-1][j];
				}
				else if (j == i) {
					dp[i][j] += dp[i-1][j-1];
				}
				else {
					dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (dp[n-1][i] > max) max = dp[n-1][i];
		}
		
		System.out.println(max);
	}
}
