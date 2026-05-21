import java.util.*;

class Solution {

    Node flatten(Node root) {
        
        if (root == null || root.next == null)
            return root;
        
        Node mergedHead = flatten(root.next);
        return merge(root, mergedHead);
    }
    
    private Node merge(Node a, Node b) {
        
        Node dummy = new Node(0);
        Node temp = dummy;
        
        while (a != null && b != null) {
            
            if (a.data <= b.data) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
            
            temp = temp.bottom;
            temp.next = null;
        }
        
        if (a != null) temp.bottom = a;
        else temp.bottom = b;
        
        return dummy.bottom;
    }
}