package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] timeList = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			timeList[i][0] = Integer.parseInt(st.nextToken());
			timeList[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(timeList, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			else if (a[1] == b[1]) {
				return Integer.compare(a[0], b[0]);
			}
			else {
				return Integer.compare(a[1], b[1]);
			}
		});
		
		int count = 1;
		int end = timeList[0][1];
		for (int i = 1; i < N; i++) {
			if (timeList[i][0] >= end) {
				end = timeList[i][1];
//				System.out.println(timeList[0][i] + ", " + timeList[1][i]);
				count++;
			}
		}
		
		bw.write(count + "");
		bw.flush();
		
		br.close();
		bw.close();
	
	}
}
