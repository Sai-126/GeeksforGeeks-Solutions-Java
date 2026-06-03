class Solution {
    // GFG driver code might be looking for this name
    public int maxProfit(int[] prices) {
        return calculateProfit(prices);
    }

    // Or it might be looking for this name
    public int maximumProfit(int[] prices) {
        return calculateProfit(prices);
    }

    // Actual logic shared by both wrapper methods
    private int calculateProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}