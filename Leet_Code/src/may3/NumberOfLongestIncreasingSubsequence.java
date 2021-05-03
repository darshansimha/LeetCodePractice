package may3;

public class NumberOfLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxLen = 1;

		int result = 0;

		if (nums.length == 1) {
			return maxLen;
		}

		int[] dp = new int[nums.length];
		dp[0] = 1;

		int currMax = 0;

		for (int i = 1; i < dp.length; i++) {
			currMax = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					currMax = Math.max(currMax, dp[j]);
				}
			}
			dp[i] = currMax + 1;

			maxLen = Math.max(dp[i], maxLen);
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < i; j++) {
				
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfLongestIncreasingSubsequence n = new NumberOfLongestIncreasingSubsequence();
		System.out.println(n.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 }));
	}

}
