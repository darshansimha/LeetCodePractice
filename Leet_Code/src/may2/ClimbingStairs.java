package may2;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		return climbStairsRec(dp, n);
	}

	public int climbStairsRec(int[] dp, int n) {
		System.out.println(n);
		if (n == 0 || n == 1) {
			return 1;
		}
		dp[n - 1] = (dp[n - 1] != 0) ? dp[n - 1] : climbStairsRec(dp, n - 1);
		dp[n - 2] = (dp[n - 2] != 0) ? dp[n - 2] : climbStairsRec(dp, n - 2);

		return dp[n - 1] + dp[n - 2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs c = new ClimbingStairs();

		System.out.println(c.climbStairs(5));
	}

}
