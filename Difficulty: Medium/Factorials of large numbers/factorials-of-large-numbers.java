import java.util.ArrayList;
import java.util.Collections;

class Solution {
    // Alias to match typical GeeksforGeeks method signatures
    public ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Base case initialization: 1! = 1
        result.add(1);
        
        // Multiply numbers from 2 up to n
        for (int i = 2; i <= n; i++) {
            multiply(result, i);
        }
        
        // Since we stored digits in reverse order, reverse the list 
        // to get the correct standard representation before returning.
        Collections.reverse(result);
        return result;
    }
    
    // Helper function to multiply the large number stored in the list by a single integer 'i'
    private void multiply(ArrayList<Integer> result, int i) {
        int carry = 0;
        int size = result.size();
        
        // Multiply 'i' with every individual digit in the array list
        for (int j = 0; j < size; j++) {
            int product = result.get(j) * i + carry;
            
            // Update the current digit slot
            result.set(j, product % 10);
            
            // Calculate the carry for the next iteration
            carry = product / 10;
        }
        
        // If there's still a carry left over after running through all digits,
        // split it and append it to the end of the list.
        while (carry != 0) {
            result.add(carry % 10);
            carry = carry / 10;
        }
    }
}