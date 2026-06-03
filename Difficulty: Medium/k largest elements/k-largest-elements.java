import java.util.*;

class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap

        for (int num : arr) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // convert to decreasing order
        Collections.sort(result, Collections.reverseOrder());

        return result;
    }
}