package april17;

import java.util.Arrays;

public class CoinChangeProblem {
	public int coinChange(int[] coins, int amount) {
		if (coins.length == 0) {
			return -1;
		}
        if(amount == 0) {
            return 0;
        }
		if (coins.length == 1) {
			if (amount == 0) {
				return 0;
			}
			if (amount < coins[0]) {
				return -1;
			}
			if (amount % coins[0] != 0) {
				return -1;
			} else {
				return amount / coins[0];
			}
		}

		int[] dp = new int[amount + 1];
		int min = Arrays.stream(coins).min().getAsInt();

		for (int i = 0; i < coins.length; i++) {
			for (int j = min; j <= amount; j++) {
				if (coins[i] <= j) {
					if (j - coins[i] >= 0) {
						if (j - coins[i] == 0) {
							dp[j] = 1;
						} else if(j - coins[i] > 0 && dp[j - coins[i]] != 0) {
							if(dp[j] != 0) {
								dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
							} else {
								dp[j] = 1 + dp[j - coins[i]];
							}
						}

					}
				}
			}
		}
		return dp[amount] == 0? -1 : dp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChangeProblem c = new CoinChangeProblem();
		System.out.println(c.coinChange(new int[] { 186,419,83,408 }, 6249));
	}

}
