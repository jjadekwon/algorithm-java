package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P4447 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		while (n-- > 0) {
			String name = br.readLine();
			int g = 0, b = 0;
			for (int i = 0; i < name.length(); i++) {
				switch(name.charAt(i)) {
				case 'g': case 'G':
					g++;
					break;
				case 'b': case 'B':
					b++;
					break;
				}
			}
			
			String print = g == b ? "NEUTRAL" : g < b ? "A BADDY" : "GOOD";
			System.out.println(name + " is " + print);
		}
	}
}
