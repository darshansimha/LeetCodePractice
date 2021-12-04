package DynamicProgramming;

public class LongestIncreasingSubsequenceLength {

	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return 1;
		}
		int result = 1;
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int currentMax = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					currentMax  = Math.max(currentMax, dp[j]);
				}
				
			}
			dp[i] = currentMax + 1;
			result = Math.max(result, dp[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubsequenceLength l = new LongestIncreasingSubsequenceLength();
		System.out.println(l.lengthOfLIS(new int[] { 4, 10, 4, 3, 8, 9 }));
	}

}
