class Solution {

    // expand around center and return length
    int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            // odd length palindrome
            int len1 = expand(s, i, i);

            // even length palindrome
            int len2 = expand(s, i, i + 1);

            int len = Math.max(len1, len2);

            // update best window
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }
}