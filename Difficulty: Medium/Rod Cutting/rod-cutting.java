class Solution {
    public int cutRod(int price[]) {
        int n = price.length;
        int[] dp = new int[n + 1];

        // dp[0] is 0 by default (a rod of length 0 has 0 value)
        
        // Build the solution for all lengths from 1 to n
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            
            // Try every possible cut j for a rod of length i
            for (int j = 1; j <= i; j++) {
                // price[j-1] is the price of a piece of length j
                // dp[i-j] is the max value for the remaining length
                maxVal = Math.max(maxVal, price[j - 1] + dp[i - j]);
            }
            
            dp[i] = maxVal;
        }

        return dp[n];
    }
}