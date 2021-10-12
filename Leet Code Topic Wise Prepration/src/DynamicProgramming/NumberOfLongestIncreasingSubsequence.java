package DynamicProgramming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return 1;
		}
		int result = 1;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int currentMax = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					currentMax = Math.max(currentMax, dp[j]);
				}

			}
			dp[i] = currentMax + 1;
			result = Math.max(result, dp[i]);
		}

		int count = 0;
		for (int i : dp) {
			if (i == result - 1) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfLongestIncreasingSubsequence n = new NumberOfLongestIncreasingSubsequence();

		System.out.println(n.findNumberOfLIS(new int[] { 2,2,2,2,2 }));
	}

}
