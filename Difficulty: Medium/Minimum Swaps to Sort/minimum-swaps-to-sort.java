class Solution {
    // Helper class defined inside Solution to prevent conflicts
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int minSwaps(int arr[]) {
        int n = arr.length;
        Pair[] arrPos = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            arrPos[i] = new Pair(arr[i], i);
        }

        // Using a lambda expression avoids needing to import java.util.Comparator explicitly
        java.util.Arrays.sort(arrPos, (p1, p2) -> Integer.compare(p1.value, p2.value));

        boolean[] visited = new boolean[n];
        int totalSwaps = 0;

        for (int i = 0; i < n; i++) {
            // If already visited or already in correct position, skip
            if (visited[i] || arrPos[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arrPos[j].index;
                cycleSize++;
            }

            if (cycleSize > 0) {
                totalSwaps += (cycleSize - 1);
            }
        }

        return totalSwaps;
    }
}