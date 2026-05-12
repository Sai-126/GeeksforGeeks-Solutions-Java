import java.util.HashSet;

class Solution {
    // Renamed to match the driver code's call
    public int intersectSize(int a[], int b[]) {
        // Step 1: Initialize a HashSet
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        // Step 2: Add all elements of the first array into the set
        // O(n) time complexity
        for (int num : a) {
            set.add(num);
        }

        // Step 3: Iterate through the second array and check for existence
        // O(m) time complexity
        for (int num : b) {
            if (set.contains(num)) {
                count++;
                // If the elements weren't distinct, we'd remove 'num' from set here
                // to avoid double counting, but the problem says they are distinct.
            }
        }

        return count;
    }
}