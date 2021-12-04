package DynamicProgramming;

public class BestTimeToBuyAndSellStockWithTransactionFee {
	public int maxProfit(int[] prices, int fee) {
		int size = prices.length;
		int[] buy = new int[size];
		int[] sell = new int[size];

		buy[0] = -1 * prices[0];
		sell[0] = 0;

		for (int i = 1; i < size; i++) {
			buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
			sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
		}
		return sell[size - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStockWithTransactionFee b = new BestTimeToBuyAndSellStockWithTransactionFee();
		System.out.println(b.maxProfit(new int[] { 1, 3, 2, 8, 4, 9 }, 2));
	}

}
