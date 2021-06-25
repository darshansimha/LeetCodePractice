package DynamicProgramming;

public class HouseRobber {

	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (i - 2 >= 0) {
				dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
			} else {
				dp[i] = Math.max(nums[i], dp[i - 1]);
			}

		}

		return dp[nums.length - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobber h = new HouseRobber();

		System.out.println(h.rob(new int[] { 1, 2, 3, 1 }));
	}

}
