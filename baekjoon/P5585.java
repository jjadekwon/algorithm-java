package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class P5585 {
	static int[] coin = new int[] { 500, 100, 50, 10, 5, 1 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int money = Integer.parseInt(br.readLine());
		int change = 1000 - money;
		
		int count = 0;
		int i = 0;
		while (change > 0) {
			count += change / coin[i];
			change %= coin[i++];
		}
		
		bw.write(count + "");
		bw.flush();
		
		br.close();
		bw.close();
	}
}
