class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Compare characters at both ends
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            
            // Move pointers towards the center
            left++;
            right--;
        }

        return true;
    }
}