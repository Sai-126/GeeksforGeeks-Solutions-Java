import java.util.*;

class Solution {
    public boolean areIsomorphic(String s1, String s2) {
        
        int n = s1.length();
        
        HashMap<Character, Character> map1 = new HashMap<>();
        HashSet<Character> used = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else {
                if (used.contains(c2)) return false;
                
                map1.put(c1, c2);
                used.add(c2);
            }
        }
        
        return true;
    }
}