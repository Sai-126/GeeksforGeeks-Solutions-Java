import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>(); // store indices
        
        for (int i = 0; i < n; i++) {
            
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            
            int span = st.isEmpty() ? (i + 1) : (i - st.peek());
            res.add(span);
            
            st.push(i);
        }
        
        return res;
    }
}