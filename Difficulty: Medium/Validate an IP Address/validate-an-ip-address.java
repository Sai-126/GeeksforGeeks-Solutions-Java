class Solution {
    public boolean isValid(String s) {
        
        String[] parts = s.split("\\.");
        
        if (parts.length != 4) return false;
        
        for (String p : parts) {
            
            if (p.length() == 0) return false;
            
            // no leading zeros (except "0")
            if (p.length() > 1 && p.charAt(0) == '0') return false;
            
            for (int i = 0; i < p.length(); i++) {
                if (!Character.isDigit(p.charAt(i))) return false;
            }
            
            int val;
            try {
                val = Integer.parseInt(p);
            } catch (Exception e) {
                return false;
            }
            
            if (val < 0 || val > 255) return false;
        }
        
        return true;
    }
}