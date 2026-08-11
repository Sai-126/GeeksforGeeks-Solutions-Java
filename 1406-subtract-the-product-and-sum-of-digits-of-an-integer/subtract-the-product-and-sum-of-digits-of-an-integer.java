class Solution {
    public int subtractProductAndSum(int n) {
        String str = String.valueOf(n);

        int product = 1;
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';

            product = product * digit;
            sum = sum + digit;
        }

        return product - sum;
    }
}