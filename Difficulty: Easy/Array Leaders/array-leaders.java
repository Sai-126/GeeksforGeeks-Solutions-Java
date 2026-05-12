import java.util.ArrayList;
import java.util.Collections;

class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        
        // The rightmost element is always a leader
        int maxFromRight = arr[n - 1];
        result.add(maxFromRight);
        
        // Traverse the array from right to left (starting from the second to last)
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                result.add(maxFromRight);
            }
        }
        
        // The leaders were added in reverse order (right to left)
        // We need to reverse the list to maintain original relative order
        Collections.reverse(result);
        
        return result;
    }
}