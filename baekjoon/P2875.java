package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int team = M * 2 <= N ? M : N / 2;
		int rest = (N + M) - team * 3;
		if (rest < K) {
			int p = (K - rest) / 3;
			int q = (K - rest) % 3;
			
			if (q != 0) ++p;
			team -= p;
		}
		
		bw.write(team + "");
		bw.flush();
		
		br.close();
		bw.close();
	}
}
