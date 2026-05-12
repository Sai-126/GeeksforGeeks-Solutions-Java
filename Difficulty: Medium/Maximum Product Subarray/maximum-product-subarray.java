class Solution {
    // Function to find maximum product subarray
    public int maxProduct(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // Initialize with the first element
        int maxSoFar = arr[0];
        int minSoFar = arr[0];
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            int curr = arr[i];

            // If current element is negative, max and min will swap
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // The max product at curr is either curr itself 
            // or curr multiplied by the previous max
            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            // Update the global maximum
            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}