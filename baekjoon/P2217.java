package baekjoon;

import java.io.*;
import java.util.Arrays;

public class P2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weight = new int[N];
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(weight);
		
		int maxWeight = 0;
		for (int i = 0; i < N; i++) {
			int sum = weight[i] * (N - i);
			if (maxWeight < sum) maxWeight = sum;
		}
		
		System.out.println(maxWeight);
		
		br.close();
	}
}
