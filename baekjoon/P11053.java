package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		int[] dp = new int[N];
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			
			int count = 1;
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i]) {
					if (count < dp[j] + 1) count = dp[j] + 1;
				}
			}
			
			dp[i] = count;
			if (max < count) max = count;
		}
		
		bw.write(max + "");
		bw.flush();
		
		br.close();
		bw.close();
	
	}
}
