package DynamicProgramming;

public class CombinationSum4 {
	public int combinationSum4(int[] nums, int target) {
		int size = nums.length;
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < size; j++) {
				if (nums[j] <= i) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationSum4 c = new CombinationSum4();
		System.out.println(c.combinationSum4(new int[] {1,2,3}, 4));
	}

}
