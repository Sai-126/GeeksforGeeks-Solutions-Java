import java.util.Arrays;

class Solution {
    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Initial difference between max and min
        int ans = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 0; i < n - 1; i++) {
            // Potential new min and max
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);

            // Constraint: Heights cannot be negative
            if (minHeight < 0) continue;

            // Update the minimum difference
            ans = Math.min(ans, maxHeight - minHeight);
        }

        return ans;
    }
}