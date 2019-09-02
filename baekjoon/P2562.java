package baekjoon;

import java.io.*;

public class P2562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > max) {
				max = num;
				index = i;
			}
		}

		System.out.println(max);
		System.out.println(index+ 1);
		
		br.close();
	}
}
