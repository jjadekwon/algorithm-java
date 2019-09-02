package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P2164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while (q.size() > 1) {
			q.poll();
			
			if (!q.isEmpty()) {
				q.offer(q.poll());
			}
		}
		
		System.out.println(q.element());
	}
}
