class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Compare middle element with its right neighbor
            if (arr[mid] < arr[mid + 1]) {
                // We are on an upward slope. 
                // The peak must be to the right (excluding mid).
                low = mid + 1;
            } else {
                // We are on a downward slope. 
                // The peak is either mid or to the left of mid.
                high = mid;
            }
        }

        // low and high will converge to a peak element index
        return low;
    }
}