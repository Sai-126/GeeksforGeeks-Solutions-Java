import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Map to store (prefix_sum, earliest_index)
        HashMap<Long, Integer> map = new HashMap<>();
        long currentSum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Case 1: Subarray starts from index 0
            if (currentSum == k) {
                maxLen = i + 1;
            }

            // Case 2: Check if (currentSum - k) exists in the map
            // If it does, the elements between that index and i sum to k
            if (map.containsKey(currentSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(currentSum - k));
            }

            // Only add the currentSum to the map if it's not already there
            // This ensures we keep the leftmost index for a specific sum
            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }
        }

        return maxLen;
    }
}