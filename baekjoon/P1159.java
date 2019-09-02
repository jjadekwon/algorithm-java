package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1159 {
	public static char[] lastName = new char[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while (N-- > 0) {
			String name = br.readLine();
			int index = name.charAt(0) - 97;
			lastName[index]++;
		}
		
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (lastName[i] > 4) {
				System.out.print((char)(i + 97));
				count++;
			}
		}
		
		if (count == 0) {
			System.out.println("PREDAJA");
		}
	}
}
