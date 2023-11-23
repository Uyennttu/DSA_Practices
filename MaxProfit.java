package dsa;

public class MaxProfit {
	public static void main(String[] args) {
		int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };
		System.out.println("Maximum Profit: " + maxProfit(A));
	}

	public static int maxProfit(int[] A) {
		int minPrice = A[0];
		int maxProfit = 0;

		for (int i = 1; i < A.length; i++) {
			minPrice = Math.min(minPrice, A[i]);
			maxProfit = Math.max(maxProfit, A[i] - minPrice);
		}
		return maxProfit;

	}

}
