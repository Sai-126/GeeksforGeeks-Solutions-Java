import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // Initialize min and max with the first element
        int min = arr[0];
        int max = arr[0];

        // Traverse the array to find actual min and max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create the ArrayList the driver code expects
        ArrayList<Integer> result = new ArrayList<>();
        result.add(min);
        result.add(max);

        return result;
    }
}