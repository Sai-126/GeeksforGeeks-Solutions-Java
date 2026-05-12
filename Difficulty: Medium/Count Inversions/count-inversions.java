class Solution {
    static long inversionCount(int arr[]) {
        return mergeSortAndCount(arr, 0, arr.length - 1);
    }

    private static long mergeSortAndCount(int[] arr, int l, int r) {
        long count = 0;
        if (l < r) {
            int m = l + (r - l) / 2;

            // Count inversions in left and right halves
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);

            // Count split inversions during merge
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    private static long mergeAndCount(int[] arr, int l, int m, int r) {
        // Create copies of left and right subarrays
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];

        for (int i = 0; i < left.length; i++) left[i] = arr[l + i];
        for (int j = 0; j < right.length; j++) right[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        long swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                // Core Logic: If left[i] > right[j], then all elements 
                // from left[i] to left[last] are greater than right[j].
                swaps += (left.length - i);
            }
        }

        // Fill remaining elements
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];

        return swaps;
    }
}