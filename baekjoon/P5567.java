package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5567 {
	public static int n;
	public static boolean[][] arr;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		arr = new boolean[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(arr[i], false);
		}
		
		visited = new boolean[n + 1];
		
		while (m-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			arr[num1][num2] = true;
			arr[num2][num1] = true;
		}
		
		System.out.println(findFriends());
	}
	
	public static int findFriends() {
		int count = 0;
		int level = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visited[1] = true;
		while (level != 2) {
			int size = queue.size();
			while (size-- > 0) {
				int num = queue.poll();
				for (int i = 1; i <= n; i++) {
					if (arr[num][i] && !visited[i]) {
						queue.offer(i);
						visited[i] = true;
						count++;
					}
				}
			}
			
			level++;
		}
		
		return count;
	}
}