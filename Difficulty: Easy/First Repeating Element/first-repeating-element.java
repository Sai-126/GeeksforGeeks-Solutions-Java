import java.util.*;

class Solution {
    public int firstRepeated(int[] arr) {
        
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // store frequency
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        
        // find first repeating (smallest index)
        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) > 1) {
                return i + 1; // 1-based index
            }
        }
        
        return -1;
    }
}