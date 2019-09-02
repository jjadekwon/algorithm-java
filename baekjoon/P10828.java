package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		while (N-- > 0) {
			String command = br.readLine();
			StringTokenizer st = new StringTokenizer(command);
			
			switch (st.nextToken()) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					if (stack.isEmpty()) {
						System.out.println(-1);
					}
					else {
						System.out.println(stack.pop());
					}
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					if (stack.isEmpty()) {
						System.out.println(1);
					}
					else {
						System.out.println(0);
					}
					break;
				case "top":
					if (stack.isEmpty()) {
						System.out.println(-1);
					}
					else {
						System.out.println(stack.peek());
					}
					break;
			}
		}
		
		br.close();
	}
}
