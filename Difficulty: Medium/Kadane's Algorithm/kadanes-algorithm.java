class Solution {
    // Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int[] arr) {
        // Initialize maxSoFar with the first element to handle arrays 
        // with all negative numbers correctly.
        long maxSoFar = arr[0];
        long currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Decision: Should I start fresh at arr[i] or add arr[i] to the current chain?
            currentMax = Math.max((long)arr[i], currentMax + arr[i]);
            
            // Update the global maximum found so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}