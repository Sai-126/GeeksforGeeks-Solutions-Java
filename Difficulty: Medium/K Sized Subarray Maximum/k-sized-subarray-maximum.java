import java.util.*;

class Solution {
    // Renamed to match the driver's 'maxOfSubarrays' call
    public ArrayList<Integer> maxOfSubarrays(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        // Deque will store indices in a way that the front is always the max
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            // 1. Remove indices that are now outside the window (left side)
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.pollFirst();
            }

            // 2. Remove indices of elements smaller than the current element (right side)
            // They can't be the maximum because the current element is larger and newer
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // 3. Add current element's index to the deque
            dq.offerLast(i);

            // 4. If we have processed at least k elements, the front is our window max
            if (i >= k - 1) {
                result.add(arr[dq.peekFirst()]);
            }
        }

        return result;
    }
}