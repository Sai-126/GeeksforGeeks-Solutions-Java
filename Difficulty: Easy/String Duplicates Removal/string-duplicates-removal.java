import java.util.*;

class Solution {
    String removeDuplicates(String s) {
        
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);
            
            if (!set.contains(ch)) {
                set.add(ch);
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}