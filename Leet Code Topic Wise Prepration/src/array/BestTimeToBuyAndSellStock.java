package array;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
	
	public int maxProfit(int[] prices) {
		int currMin = prices[0];
		int currMax = prices[0];
		int maxProfit = 0;
		for(int i = 1; i < prices.length; i++) {
			//i cannot be the last index since we cannot buy on the last day
			//We need to reset the local maxima and minima if we find a smaller element
			if(prices[i] < currMin && i != prices.length - 1) {
				currMin = prices[i];
				currMax = prices[i];
			}
			//Keep updating the max value
			if(prices[i] > currMax) {
				currMax = prices[i];
			}
			if(currMax - currMin > maxProfit) {
				maxProfit = currMax - currMin;
			}
		}
		
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		
		System.out.println(b.maxProfit(new int[] {3,2,6,5,0,3}));
	}

}
