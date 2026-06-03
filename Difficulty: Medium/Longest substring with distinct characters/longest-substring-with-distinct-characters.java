class Solution {
    // Alias 1: Standard GFG naming convention
    public int longestUniqueSubstr(String s) {
        return findLongestUniqueSubstr(s);
    }

    // Alias 2: Alternative naming convention
    public int longestUniqueSubsetString(String s) {
        return findLongestUniqueSubstr(s);
    }

    // Core Logic
    private int findLongestUniqueSubstr(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Array to store the last seen index of each character (initialized to -1)
        int[] lastSeen = new int[256];
        for (int i = 0; i < 256; i++) {
            lastSeen[i] = -1;
        }

        int maxLength = 0;
        int left = 0;

        // Sliding window: 'right' expands the window
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already seen and is inside the current window,
            // shrink the window by moving 'left' past the previous occurrence.
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }

            // Update the last seen position of the character
            lastSeen[currentChar] = right;

            // Calculate and update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}