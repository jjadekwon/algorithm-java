package baekjoon;

import java.io.*;

public class P10844 {
	static final int mod = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long[][] dp = new long[101][10];

		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j+1] % mod;
				}
				else if (j == 9) {
					dp[i][j] = dp[i-1][j-1] % mod;
				}
				else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % mod;
				}
			}
		}
		
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[N][i];
		}
		
		bw.write(sum % mod + "");
		bw.flush();
		
		br.close();
		bw.close();
	}
}
