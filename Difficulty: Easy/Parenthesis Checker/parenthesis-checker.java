import java.util.Stack;

class Solution {
    // Function to check if brackets are balanced or not.
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            // Push opening brackets to the stack
            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            } 
            else {
                // If we hit a closing bracket and the stack is empty, it's unbalanced
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Check if the closing bracket matches the last opened one
                if ((current == ')' && top != '(') ||
                    (current == '}' && top != '{') ||
                    (current == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}