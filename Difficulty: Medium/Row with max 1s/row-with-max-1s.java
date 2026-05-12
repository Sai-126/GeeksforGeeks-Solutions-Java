class Solution {
    public int rowWithMax1s(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        
        int maxRowIndex = -1;
        
        // Start from top-right corner
        int r = 0;
        int c = m - 1;
        
        while (r < n && c >= 0) {
            if (arr[r][c] == 1) {
                // If we find a 1, this row is the current leader.
                // Move left to see if there are more 1s in this row.
                maxRowIndex = r;
                c--;
            } else {
                // If we find a 0, move down to the next row.
                r++;
            }
        }
        
        return maxRowIndex;
    }
}