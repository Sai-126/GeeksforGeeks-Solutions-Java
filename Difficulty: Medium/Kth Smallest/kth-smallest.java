import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Max-Heap to store the k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            maxHeap.add(num);

            // If heap size exceeds k, remove the largest element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // The top of the max-heap is the kth smallest element
        return maxHeap.peek();
    }
}