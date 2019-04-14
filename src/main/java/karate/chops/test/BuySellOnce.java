package karate.chops.test;

public class BuySellOnce {
	public static void main(final String[] args) {
		int[] A = new int[] { 310, 315, 275, 295, 260, 270, 290, 230, 265 };
		int maxProfit = calcProfit(A);
		System.out.println(maxProfit);
	}

//	private static int calcProfit(int[] A) {
//		int profit = Integer.MIN_VALUE;
//		int buyingPrice =A[0];
//		
//		for(int i=1;i<A.length;i++) {
//			buyingPrice = Math.min(buyingPrice, A[i]);
//			if(A[i] > buyingPrice)
//				profit = Math.max(profit, A[i] - buyingPrice);
//		}
//		
//		return profit;
//	}
 
	private static int calcProfit(int[] A) {
		int profit = Integer.MIN_VALUE;
		int buyingPrice = Integer.MAX_VALUE;
		for (int currentPrice : A) {
			int currentProfit = currentPrice - buyingPrice;
			profit = Math.max(currentProfit, profit);
			buyingPrice = Math.min(currentPrice, buyingPrice);
		}
		return profit;
	}
}
