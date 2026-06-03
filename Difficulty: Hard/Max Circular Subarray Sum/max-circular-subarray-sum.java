class Solution {
    public static int maxCircularSum(int[] arr) {
        int n = arr.length;
        
        // Variables for Max Subarray Sum (Standard Kadane)
        int maxNormal = arr[0];
        int currentMax = arr[0];
        
        // Variables for Min Subarray Sum (Inverted Kadane)
        int minNormal = arr[0];
        int currentMin = arr[0];
        
        int totalSum = arr[0];
        
        // Traverse the array from the second element
        for (int i = 1; i < n; i++) {
            totalSum += arr[i];
            
            // Standard Kadane to find max subarray sum
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            maxNormal = Math.max(maxNormal, currentMax);
            
            // Modified Kadane to find min subarray sum
            currentMin = Math.min(arr[i], currentMin + arr[i]);
            minNormal = Math.min(minNormal, currentMin);
        }
        
        // Edge Case: If all elements are negative, maxNormal will hold the 
        // least negative number. totalSum - minNormal would return 0, which is incorrect.
        if (maxNormal < 0) {
            return maxNormal;
        }
        
        // Return the maximum of the non-wrapping and wrapping cases
        int maxCircular = totalSum - minNormal;
        return Math.max(maxNormal, maxCircular);
    }
}