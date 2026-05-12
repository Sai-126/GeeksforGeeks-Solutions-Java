class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        long totalSum = 0;
        long leftSum = 0;

        // Step 1: Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Iterate through the array to find the equilibrium point
        for (int i = 0; i < arr.length; i++) {
            // Right sum is Total - Left - Current element
            long rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            // Update leftSum for the next index
            leftSum += arr[i];
        }

        // Return -1 if no equilibrium point is found
        return -1;
    }
}
