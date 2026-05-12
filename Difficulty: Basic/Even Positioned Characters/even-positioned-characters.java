import java.util.*;

class Solution {
    // The driver code calls 'obj.utility(s)', so the name must be 'utility'
    public void utility(String s) {
        // Start at 0, increment by 2 to get indices 0, 2, 4...
        for (int i = 0; i < s.length(); i += 2) {
            System.out.print(s.charAt(i));
        }
    }
}