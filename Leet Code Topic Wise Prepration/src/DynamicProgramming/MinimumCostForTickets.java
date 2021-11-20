package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostForTickets {
	public int mincostTickets(int[] days, int[] costs) {
		int lastDay = days[days.length - 1];
		int[] dp = new int[lastDay + 1];
		// We add days to the set just to make sure if we are processing the necessary
		// days
		Set<Integer> daysToUse = new HashSet<Integer>();
		for (int i : days) {
			daysToUse.add(i);
		}
		int oneDayCost, sevenDaysCost, thirtyDayCost = 0;
		for (int i = 1; i <= days[days.length - 1]; i++) {
			if (daysToUse.contains(i)) {
				oneDayCost = dp[i - 1];
				if (i - 7 >= 0) {
					sevenDaysCost = dp[i - 7];
				} else {
					sevenDaysCost = 0;
				}
				if (i - 30 >= 0) {
					thirtyDayCost = dp[i - 30];
				} else {
					thirtyDayCost = 0;
				}
				dp[i] = Math.min(oneDayCost + costs[0], Math.min(sevenDaysCost + costs[1], thirtyDayCost + costs[2]));
			} else {
				// If this day doesn't exist in the days array, we don't have to spend anything
				// on it so it stays the same as the previous day
				dp[i] = dp[i - 1];
			}
		}
		return dp[lastDay];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumCostForTickets m = new MinimumCostForTickets();
		System.out.println(m.mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 7, 2, 15 }));
	}

}
