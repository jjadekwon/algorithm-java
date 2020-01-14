package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		long[] dp = new long[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		long max = 0;
		if (n == 1) {
			max = num[0];
		}
		else if (n == 2) {
			max = num[0] + num[1];
		}
		else {
			dp[0] = num[0];
			dp[1] = num[0] + num[1];
			dp[2] = Math.max(dp[1], Math.max(num[0] + num[2], num[1] + num[2]));
			
			for (int i = 3; i < n; i++) {
				dp[i] = num[i] + Math.max(dp[i-2], num[i-1] + dp[i-3]);
				dp[i] = Math.max(dp[i-1], dp[i]);
			}
			
			max = dp[n-1];
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(dp[i]);
//		}
		
		bw.write(max + "");
		bw.flush();
		
		br.close();
		bw.close();
	}
}
