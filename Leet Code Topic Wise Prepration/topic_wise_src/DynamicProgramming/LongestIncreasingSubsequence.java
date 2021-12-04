package DynamicProgramming;
//https://leetcode.com/problems/longest-increasing-subsequence/

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		int max = 1;
		int size = nums.length;
		int[] dp = new int[size];
		// We fill the array with one because the LIS of a single element is 1
		Arrays.fill(dp, 1);
		// This is the value we calculate for each iteration
		int currMax = 0;
		// The basic algorithm used here is that we revisit the dp values for all values
		// occuring before our current number and the numbers less than the current
		// number and add our current number to it to see if it maximizes the length of
		// the sequence.
		for (int i = 1; i < size; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					currMax = 1 + dp[j];
					dp[i] = Math.max(dp[i], currMax);
					// When our current maximum is greater than the global max we update the global
					// max
					if (currMax > max) {
						max = currMax;
					}
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
		System.out.println(l.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
	}

}
