package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE - 1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j : coins) {
				if (i - j == 0) {
					dp[i] = 1;
				}
				if (i - j > 0 && dp[i - j] != 0) {
					dp[i] = Math.min(dp[i], 1 + dp[i - j]);
				}
			}
		}
		return (dp[amount] == Integer.MAX_VALUE - 1 || dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange c = new CoinChange();
		System.out.println(c.coinChange(new int[] { 2, 5, 10, 1 }, 27));
	}

}
