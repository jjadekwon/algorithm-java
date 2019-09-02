package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P11726 {
	public static int[] d = new int[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i <= n; i++) {
			d[i] = (d[i - 1] + d[i - 2]) % 10007;
		}
		
		System.out.println(d[n]);
		
		br.close();
	}
}
