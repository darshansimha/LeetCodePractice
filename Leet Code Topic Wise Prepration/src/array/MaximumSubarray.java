package array;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		int len = nums.length;
		int[] dp = new int[len];
		dp[0] = nums[0];
		for (int i = 1; i < len; i++) {
			dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
