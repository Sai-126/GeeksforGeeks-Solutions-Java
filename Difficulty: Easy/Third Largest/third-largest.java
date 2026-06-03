import java.util.*;

class Solution {
    int thirdLargest(List<Integer> arr) {

        if (arr.size() < 3) {
            return -1;
        }

        Collections.sort(arr, Collections.reverseOrder());

        return arr.get(2);
    }
}