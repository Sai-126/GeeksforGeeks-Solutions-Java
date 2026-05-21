import java.util.*;

class Solution {
    public ArrayList<Integer> valEqualToPos(int arr[]) {
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i + 1) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}