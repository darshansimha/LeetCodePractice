package array;

public class BestTimeToBuyAndSellAStock2 {
	
	public int maxProfit(int[] prices) {
		int profit = 0;
		
		for(int i = 0; i < prices.length - 1; i++) {
			if(prices[i + 1] > prices[i]) {
				profit += prices[i + 1] - prices[i];
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellAStock2 b = new BestTimeToBuyAndSellAStock2();
		System.out.println(b.maxProfit(new int[] {3,2,6,5,0,3}));
	}

}
