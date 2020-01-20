package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class P10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int sum = 0;
		
		String input = br.readLine();
		boolean hasZero = false;
		
		Integer[] arr = new Integer[input.length()];
		for (int i = 0; i < input.length(); i++) {
			arr[i] = input.charAt(i) - '0';
			sum += arr[i];
			
			if (arr[i] == 0) hasZero = true;
		}
		
		if (sum % 3 != 0 || !hasZero) {
			bw.write("-1");
		}
		else {
			Arrays.sort(arr, Collections.reverseOrder());
			for (int i = 0; i < arr.length; i++) {
				bw.write(arr[i] + "");
			}
		}
		
		bw.flush();
		
		br.close();
		bw.close();
	}
}
