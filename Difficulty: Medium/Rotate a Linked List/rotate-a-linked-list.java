class Solution {
    public Node rotate(Node head, int k) {
        
        if (head == null || head.next == null || k == 0)
            return head;
        
        // find length
        Node curr = head;
        int len = 1;
        
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        
        // make circular
        curr.next = head;
        
        // IMPORTANT: take k modulo length
        k = k % len;
        
        // if no rotation
        if (k == 0) {
            curr.next = null;
            return head;
        }
        
        // new head is k-th node
        Node newTail = head;
        
        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }
        
        Node newHead = newTail.next;
        
        // break the list
        newTail.next = null;
        
        return newHead;
    }
}