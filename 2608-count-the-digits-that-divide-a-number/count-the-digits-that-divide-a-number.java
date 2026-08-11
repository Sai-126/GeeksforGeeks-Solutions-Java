class Solution {
    public int countDigits(int num) {
        String str = String.valueOf(num);
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';

            if (digit != 0 && num % digit == 0) {
                count++;
            }
        }

        return count;
    }
}