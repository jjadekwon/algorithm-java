package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class P1697 {
	static final int MAX = 100001;
	static boolean[] visited = new boolean[MAX];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		visited[N] = true;
		int second = 0;
		boolean find = false;
		while (true) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int next = queue.poll();
				if (next == K) {
					find = true;
					break;
				}
				
				if (next + 1 < MAX && visited[next + 1] == false) {
					queue.offer(next + 1);
					visited[next + 1] = true;
				}
				
				if (next - 1 >= 0 && visited[next - 1] == false) {
					queue.offer(next - 1);
					visited[next - 1] = true;
				}
				
				if (next * 2 < MAX && visited[next * 2] == false) {
					queue.offer(next * 2);
					visited[next * 2] = true;
				}
			}
			
			if (find) break;
			
			second++;
		}
		
		System.out.println(second);
	}
}