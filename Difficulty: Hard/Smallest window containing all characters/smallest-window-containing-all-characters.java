class Solution {
    // Renamed from smallestWindow to minWindow to match your driver code
    public static String minWindow(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return "";
        }

        int[] pMap = new int[256];
        for (int i = 0; i < p.length(); i++) {
            pMap[p.charAt(i)]++;
        }

        int[] sMap = new int[256];
        
        int left = 0, right = 0;
        int count = 0; 
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        while (right < s.length()) {
            char rChar = s.charAt(right);
            sMap[rChar]++;

            if (pMap[rChar] != 0 && sMap[rChar] <= pMap[rChar]) {
                count++;
            }

            while (count == p.length()) {
                int currentWindowLen = right - left + 1;
                
                if (currentWindowLen < minLen) {
                    minLen = currentWindowLen;
                    startIndex = left;
                }

                char lChar = s.charAt(left);
                sMap[lChar]--;

                if (pMap[lChar] != 0 && sMap[lChar] < pMap[lChar]) {
                    count--;
                }
                
                left++; 
            }
            right++; 
        }

        if (startIndex == -1) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLen);
    }
}