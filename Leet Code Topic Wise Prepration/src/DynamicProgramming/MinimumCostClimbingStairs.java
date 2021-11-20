package DynamicProgramming;

public class MinimumCostClimbingStairs {
	public int minCostClimbingStairs(int[] cost) {
		int size = cost.length;
		if (size == 1) {
			return cost[0];
		}
		if (size == 2) {
			return Math.min(cost[0], cost[1]);
		}
		int[] dp = new int[size];
		dp[0] = cost[0];
		dp[1] = cost[1];
		for (int i = 2; i < size; i++) {
			dp[i] = Math.min(cost[i] + dp[i - 1], cost[i] + dp[i - 2]);
		}
		// By returning dp[size - 1] or dp[size - 2] we make sure we don't add the cost
		// of the last step which is the expected output in the proble

		return Math.min(dp[size - 1], dp[size - 2]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
