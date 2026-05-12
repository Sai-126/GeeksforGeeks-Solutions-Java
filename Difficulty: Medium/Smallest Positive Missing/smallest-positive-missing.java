class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // 1. Move each number to its correct index: 
        // Number 'x' should be at index 'x-1'
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                // Swap arr[i] with the element at its target position
                int targetPos = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[targetPos];
                arr[targetPos] = temp;
            }
        }

        // 2. Find the first index that doesn't contain the correct number
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // 3. If all numbers 1 to n are present, the missing is n + 1
        return n + 1;
    }
}