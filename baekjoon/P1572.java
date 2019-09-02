package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1572 {
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int center = (K + 1) / 2 - 1;
		//int lastIndex = K % 2 == 0 ? (K + 1) / 2 : (K + 1) / 2 - 1;
		long sum = 0;
		int[] part = new int[K];
		int index = 0;
		for (int i = K - 1; i < N; i++) {
			for (int j = i - K + 1; j <= i; j++) {
				part[index++] = arr[j];
			}
			
			// 정렬
			Arrays.sort(part);
			
			// 중앙값
			sum += part[center];
			index = 0;
		}
		
		System.out.println(sum);
	}
}
