class Solution {
    // Renamed from missingNumber to missingNum
    public int missingNum(int[] arr) {
        int n = arr.length + 1;
        
        // n*(n+1)/2 formula
        long expectedSum = (long) n * (n + 1) / 2;
        long actualSum = 0;
        
        for (int num : arr) {
            actualSum += num;
        }
        
        return (int) (expectedSum - actualSum);
    }
}