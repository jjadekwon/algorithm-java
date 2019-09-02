package leetcode;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 3, 5};
		int[] nums2 = new int[] {2, 4, 6};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	
	// Runtime: 2 ms, faster than 100.00% of Java online submissions for Median of Two Sorted Arrays.
	// Memory Usage: 46.4 MB, less than 90.38% of Java online submissions for Median of Two Sorted Arrays.
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        int i, j, k;
        i = j = k = 0;
		int[] nums = new int[length1 + length2];
        while (i < length1 && j < length2) {
        	nums[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        
        if (i == length1) {
        	for (; k < nums.length; k++) {
            	nums[k] = nums1[j++];
            }
        }
        else {
        	for (; k < nums.length; k++) {
            	nums[k] = nums1[i++];
            }
        }
        
        if (nums.length % 2 == 0) return (double)(nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        else return nums[nums.length / 2];        
    }
}
