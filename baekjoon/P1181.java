package baekjoon;
import java.io.*;
import java.util.*;

public class P1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Set<String> set = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				// 길이가 같은 경우
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				// 길이 비교
				else {
					if (s1.length() < s2.length()) return -1;
					else return 1;
				}
			}
		});
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
//		String[] arr = new String[N];
//		for (int i = 0; i < N; i++) {
//			arr[i] = br.readLine();
//		}
//		
//		Arrays.sort(arr, new Comparator<>() {
//			@Override
//			public int compare(String s1, String s2) {
//				// TODO Auto-generated method stub
//				// 길이가 같은 경우
//				if (s1.length() == s2.length()) {
//					return s1.compareTo(s2);
//				}
//				// 길이 비교
//				else {
//					if (s1.length() < s2.length()) return -1;
//					else return 1;
//				}
//			}
//		});
//		
//		// 중복 제거
//		for (int i = 0; i < arr.length - 1; i++) {
//			if (arr[i].equals(arr[i + 1])) continue;
//			
//			System.out.println(arr[i]);
//		}
//		
//		// 마지막 값 출력
//		System.out.println(arr[N - 1]);
	}
}
