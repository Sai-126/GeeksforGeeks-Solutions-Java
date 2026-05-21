import java.util.*;

class Solution {
    public boolean pythagoreanTriplet(int[] arr) {
        
        int n = arr.length;
        
        // find max element
        int max = 0;
        for (int x : arr) {
            max = Math.max(max, x);
        }
        
        long[] freq = new long[max + 1];
        
        for (int x : arr) {
            freq[x]++;
        }
        
        for (int i = 1; i <= max; i++) {
            if (freq[i] == 0) continue;
            
            for (int j = i; j <= max; j++) {
                if (freq[j] == 0) continue;
                
                int c2 = i * i + j * j;
                int c = (int)Math.sqrt(c2);
                
                if (c <= max && c * c == c2 && freq[c] > 0) {
                    
                    if (c == i && freq[i] < 2) continue;
                    if (c == j && freq[j] < 2) continue;
                    
                    return true;
                }
            }
        }
        
        return false;
    }
}