package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1068 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nodes = new int[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = Integer.parseInt(st.nextToken());
		}

		int delete = Integer.parseInt(br.readLine());
		// 루트 지움
		if (nodes[delete] == -1) {
			System.out.println(0);
		}
		else {
			nodes[delete] = -2;
			deleteNode(nodes, delete);

			int count = 0;
			for (int i = 0; i < N; i++) {
				// 이미 삭제됨
				if (nodes[i] == -2) continue;
				
				// 본인 번호가 있으면 leaf node 아님
				boolean isLeafNode = true;
				for (int j = 0; j < N; j++) {
					if (nodes[j] == i) {
						isLeafNode = false;
						break;
					}
				}
				if (isLeafNode) count++;
			}
			
			// 루트 하나만 남은 경우
			if (count == 0) count = 1;
			
			System.out.println(count);
		}		
		
		br.close();
	}
	
	public static void deleteNode(int[] nodes, int delete) {
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] == delete) {
				nodes[i] = -2;
				deleteNode(nodes, i);
			}
		}
	}
}
