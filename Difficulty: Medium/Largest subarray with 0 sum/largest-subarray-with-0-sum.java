import java.util.HashMap;

class Solution {
    // Renamed from maxLen to maxLength to match the driver code
    int maxLength(int arr[]) {
        // HashMap to store (prefix_sum, first_occurrence_index)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max_len = 0;
        int current_sum = 0;

        for (int i = 0; i < arr.length; i++) {
            current_sum += arr[i];

            // If sum is 0, subarray starts from index 0
            if (current_sum == 0) {
                max_len = i + 1;
            }

            // If this sum has been seen before, there's a zero-sum subarray
            if (map.containsKey(current_sum)) {
                // Get the length from the first time we saw this sum
                int prev_index = map.get(current_sum);
                max_len = Math.max(max_len, i - prev_index);
            } else {
                // Store only the first occurrence to maximize the length
                map.put(current_sum, i);
            }
        }

        return max_len;
    }
}