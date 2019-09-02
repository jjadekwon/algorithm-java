package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int index = 0;
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (index == 0) {
					System.out.println(0);
				}
				else {
					// 출력
					System.out.println(arr[0]);
					
					// 마지막 노드 루트로 변경
					arr[0] = arr[--index];
					
					// 정렬
					heapSort(arr, index);
				}
			}
			else {
				arr[index++] = x;

				// 정렬
				if (index > 1) heapSort(arr, index);
			}
		}
	}
	
	public static void heapSort(int arr[], int size) {
		for (int i = (size - 2) / 2; i >= 0; i--) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			if (left > size && right > size) continue;
			
			int minIndex = left;
			if (right < size) {
				minIndex = arr[minIndex] > arr[right] ? right : minIndex;
			}
			
			if (arr[i] > arr[minIndex]) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;	
			}
		}
	}
}
