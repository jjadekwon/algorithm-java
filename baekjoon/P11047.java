package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		int total = 0;
		for (int i = N - 1; i >= 0; i--) {
			if (coin[i] <= K) {
				int count = K / coin[i];
				total += count;
				K = K - count * coin[i];
			}
		}
		
		System.out.println(total);
		
		br.close();
	}
}
