
class Solution {
    // Change the parameters from (int[] arr, int n, int target) 
    // to just (int[] arr, int target)
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        long currentSum = 0;
        int n = arr.length; // Get the size directly from the array

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            while (currentSum > target && start < end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == target) {
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }
        }

        result.add(-1);
        return result;
    }
}
