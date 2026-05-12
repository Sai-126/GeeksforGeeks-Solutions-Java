class Solution {
    // Function to reverse words in a given string.
    public String reverseWords(String s) {
        // Split the string by one or more dots
        // The "\\" is necessary because dot is a special character in regex
        String[] words = s.split("\\.");
        
        StringBuilder result = new StringBuilder();
        
        // Traverse the words array from the back to the front
        for (int i = words.length - 1; i >= 0; i--) {
            // Check if the word is not empty (handles multiple dots)
            if (!words[i].isEmpty()) {
                result.append(words[i]);
                
                // Add a dot if this is not the last word we're adding
                result.append(".");
            }
        }
        
        // Remove the trailing dot if the result is not empty
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        
        return result.toString();
    }
}