package leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	// Runtime: 8 ms, faster than 68.16% of Java online submissions for Longest Substring Without Repeating Characters.
	// Memory Usage: 36.9 MB, less than 99.79% of Java online submissions for Longest Substring Without Repeating Characters.
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> subString = new HashSet<Character>();
		
		int max = 0;
		int i = 0;
		int j = 0;
		
		while (j < s.length()) {
			char c = s.charAt(j++);
			if (subString.add(c)) {
				
				if (max < j - i) max = j - i;
			}
			else {
				while (!subString.add(c)) {
					subString.remove(s.charAt(i++));
				}
			}
		}
		
		return max;
    }
	
	// Runtime: 103 ms, faster than 8.85% of Java online submissions for Longest Substring Without Repeating Characters.
	// Memory Usage: 38.3 MB, less than 56.95% of Java online submissions for Longest Substring Without Repeating Characters.
//	public static int lengthOfLongestSubstring(String s) {
//		int max = 0;
//		String newString = "";
//		for (int i = 0; i < s.length(); i++) {
//			for (int j = i; j < s.length(); j++) {
//				String c = s.charAt(j) + "";
//				if (newString.contains(c)) break;
//		   
//				newString += c;
//			}
//			
//			if (max < newString.length()) max = newString.length();
//			
//			newString = "";
//       }
//		
//		return max;
//    }
}
