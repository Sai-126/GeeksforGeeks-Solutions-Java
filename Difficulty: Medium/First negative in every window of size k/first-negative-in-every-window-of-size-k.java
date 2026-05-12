import java.util.*;

class Solution {
    // Renamed to match driver code and changed return type to List<Integer>
    public List<Integer> firstNegInt(int arr[], int k) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        
        // Deque to store indices of negative numbers
        Deque<Integer> dq = new LinkedList<>();

        // 1. Process the first window of size k
        for (int i = 0; i < k; i++) {
            if (arr[i] < 0) {
                dq.add(i);
            }
        }

        // Add result for the first window
        if (!dq.isEmpty()) {
            result.add(arr[dq.peek()]);
        } else {
            result.add(0);
        }

        // 2. Process the rest of the windows
        for (int i = k; i < n; i++) {
            // Remove the index from the front if it's out of the current window
            // The current window starts at (i - k + 1)
            if (!dq.isEmpty() && dq.peek() < (i - k + 1)) {
                dq.poll();
            }

            // Add the current index if the element is negative
            if (arr[i] < 0) {
                dq.add(i);
            }

            // Get the first negative for the current window
            if (!dq.isEmpty()) {
                result.add(arr[dq.peek()]);
            } else {
                result.add(0);
            }
        }

        return result;
    }
}