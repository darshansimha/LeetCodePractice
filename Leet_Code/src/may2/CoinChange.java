package may2;

import java.util.Arrays;

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];

		Arrays.fill(dp, Integer.MAX_VALUE - 1);

		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] == 0) {
					dp[i] = 1;
				} else if (i - coins[j] > 0) {
					dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
				}

			}
		}

		return (dp[amount] == Integer.MAX_VALUE || dp[amount] == Integer.MAX_VALUE - 1) ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange c = new CoinChange();
		System.out.println(c.coinChange(new int[] { 1, 2, 5 }, 11));
	}

}
