class Solution {
    public boolean isRotated(String s1, String s2) {
        
        if (s1.length() != s2.length()) return false;
        if (s1.length() <= 2) return s1.equals(s2);
        
        String clock = s1.substring(2) + s1.substring(0, 2);
        String antiClock = s1.substring(s1.length() - 2) + s1.substring(0, s1.length() - 2);
        
        return s2.equals(clock) || s2.equals(antiClock);
    }
}