class Solution {
    // Alias 1: In case the driver code calls circularSubarraySum
    public int circularSubarraySum(int arr[]) {
        return findMaxCircularSum(arr);
    }

    // Alias 2: In case the driver code calls maxCircularSum
    public int maxCircularSum(int arr[]) {
        return findMaxCircularSum(arr);
    }

    // Core Logic Implementation
    private int findMaxCircularSum(int[] arr) {
        int n = arr.length;
        
        // Variables for Maximum Subarray Sum (Standard Kadane)
        int maxNormal = arr[0];
        int currentMax = arr[0];
        
        // Variables for Minimum Subarray Sum (Inverted Kadane)
        int minNormal = arr[0];
        int currentMin = arr[0];
        
        int totalSum = arr[0];
        
        // Traverse the array to calculate all needed values in O(N)
        for (int i = 1; i < n; i++) {
            totalSum += arr[i];
            
            // Standard Kadane's algorithm for max subarray
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxNormal = Math.max(maxNormal, currentMax);
            
            // Modified Kadane's algorithm for min subarray
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minNormal = Math.min(minNormal, currentMin);
        }
        
        // Edge Case: If all numbers are negative, maxNormal holds the largest negative value.
        // totalSum - minNormal would give 0 (empty subarray), which is invalid.
        if (maxNormal < 0) {
            return maxNormal;
        }
        
        // Maximum circular sum is the total sum minus the minimum subarray sum
        int maxCircular = totalSum - minNormal;
        
        // Return the best result out of wrapping and non-wrapping cases
        return Math.max(maxNormal, maxCircular);
    }
}