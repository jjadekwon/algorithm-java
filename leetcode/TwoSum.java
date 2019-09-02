package leetcode;

public class TwoSum {
	public static void main(String[] args) {
		int[] result = twoSum(new int[] {2, 7, 11, 15}, 9);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
	
	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					return new int[] {i, j};
				}
			}
		}
		
		return null;
	}
}
