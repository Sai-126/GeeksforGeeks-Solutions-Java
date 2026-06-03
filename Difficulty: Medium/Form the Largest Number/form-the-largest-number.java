import java.util.*;

class Solution {
    public String findLargest(int[] arr) {

        String[] nums = new String[arr.length];

        // convert int -> string
        for (int i = 0; i < arr.length; i++) {
            nums[i] = String.valueOf(arr[i]);
        }

        // custom sort
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // edge case: all zeros
        if (nums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String s : nums) {
            sb.append(s);
        }

        return sb.toString();
    }
}