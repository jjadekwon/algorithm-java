package baekjoon;

import java.io.*;

public class P2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long result = 0;
		if (N < 3) {
			result = 1;
		}
		else {
			long[][] dp = new long[2][N + 1];
			dp[0][2] = 1;
			dp[1][2] = 0;
			
			for (int i = 3; i <= N; ++i) {
				dp[0][i] += dp[0][i - 1] + dp[1][i - 1];
				dp[1][i] += dp[0][i - 1];
			}
			
			result = dp[0][N] + dp[1][N];
		}
		
		bw.write(result + "");

		bw.flush();
		bw.close();
		br.close();
	}
}
