package leetcode;

public class LongestPalindromicSubstring {
	public static void main(String[] args) {
		System.out.println(longestPalindrome("aa"));
	}
	
	// Runtime: 6 ms, faster than 86.53% of Java online submissions for Longest Palindromic Substring.
	// Memory Usage: 36.5 MB, less than 99.98% of Java online submissions for Longest Palindromic Substring.
	public static String longestPalindrome(String s)
	{
		if (s.length() < 2) return s;
		
		char[] charArr = s.toCharArray();
		int N = charArr.length * 2 + 1;
		
		char[] inputDummy = new char[N];
		int j = 0;
		for (int i = 0; i < N - 1; i+=2) {
			inputDummy[i] = '#';
			inputDummy[i + 1] = charArr[j++];
		}
		inputDummy[N - 1] = '#';
		
		int[] A = new int[N];
		int r = 0;
		int p = 0;
		for (int i = 0; i < N; i++) {
			if (i >= r) A[i] = 0;
			else A[i] = Math.min(A[2 * p - i], r - i);
				
			// 양쪽이 대칭인 경우
			while (i - A[i] - 1 >= 0 && i + A[i] + 1 < N && inputDummy[i - A[i] - 1] == inputDummy[i + A[i] + 1])
				A[i]++;
			
			if (A[p] < A[i]) {
				r = i + A[i];
				p = i;
			}
		}
		
		String result = "";
		for (int i = p - A[p]; i < r; i++) {
			if (inputDummy[i] != '#') result += inputDummy[i];
		}
		
		return result;
	}
	
	// Runtime: 700 ms, faster than 5.23% of Java online submissions for Longest Palindromic Substring.
	// Memory Usage: 36.6 MB, less than 99.96% of Java online submissions for Longest Palindromic Substring.
//	public static String longestPalindrome(String s) {
//		if (s.length() == 1) return s;
//		
//		int max = 0;
//		String str = "";
//        for (int i = 0; i < s.length(); i++) {
//        	char c = s.charAt(i);
//        	int index = i + 1;
//        	
//        	while (index < s.length()) {
//            	int endIndex = s.indexOf(c, index);
//            	if (endIndex == -1) {
//            		if (max < 1) {
//            			str = c + "";
//                		max = 1;
//            		}
//            		break;
//            	}
//            	
//            	String sub = s.substring(i, endIndex + 1);
//            	if (isPalindromicString(sub)) {
//            		if (sub.length() > max) {
//            			max = sub.length();
//            			str = sub;
//            		}
//            	}
//            	index = endIndex + 1;
//        	}
//        }
//        
//        return str;
//    }
//	
//	public static boolean isPalindromicString(String s) {
//		for (int i = 0; i < s.length() / 2; i++) {
//			if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
//		}
//		
//		return true;
//	}
}
