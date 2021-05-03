package may3;

public class LongestIncreasingSubSequence {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int result = 1;

		if (nums.length == 1) {
			return result;
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

			result = Math.max(dp[i], result);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubSequence l = new LongestIncreasingSubSequence();

		System.out.println(l.lengthOfLIS(new int[] { 4, 10, 4, 3, 8, 9 }));
	}

}
