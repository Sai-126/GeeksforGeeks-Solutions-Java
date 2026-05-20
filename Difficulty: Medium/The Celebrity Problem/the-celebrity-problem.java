class Solution {
    int celebrity(int mat[][]) {
        int n = mat.length;

        int a = 0;
        int b = n - 1;

        // Step 1: find potential celebrity
        while (a < b) {
            if (mat[a][b] == 1) {
                // a knows b → a cannot be celebrity
                a++;
            } else {
                // a doesn't know b → b cannot be celebrity
                b--;
            }
        }

        int candidate = a;

        // Step 2: verify candidate
        for (int i = 0; i < n; i++) {
            if (i != candidate) {
                // candidate should not know anyone
                if (mat[candidate][i] == 1) return -1;

                // everyone should know candidate
                if (mat[i][candidate] == 0) return -1;
            }
        }

        return candidate;
    }
}