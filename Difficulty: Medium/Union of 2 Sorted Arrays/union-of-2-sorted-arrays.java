import java.util.*;

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = a.length;
        int m = b.length;

        while (i < n && j < m) {
            int current;
            if (a[i] < b[j]) {
                current = a[i++];
            } else if (b[j] < a[i]) {
                current = b[j++];
            } else {
                current = a[i++];
                j++; // Both are equal, move both pointers
            }

            // Only add if the result is empty or the element is not a duplicate
            if (result.isEmpty() || result.get(result.size() - 1) != current) {
                result.add(current);
            }
        }

        // Add remaining elements of a[]
        while (i < n) {
            if (result.get(result.size() - 1) != a[i]) {
                result.add(a[i]);
            }
            i++;
        }

        // Add remaining elements of b[]
        while (j < m) {
            if (result.get(result.size() - 1) != b[j]) {
                result.add(b[j]);
            }
            j++;
        }

        return result;
    }
}