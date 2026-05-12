/*
class Node {
    int data;
    Node next;
    Node(int value) {
        this.data = value;
        this.next = null;
    }
}
*/

class Solution {
    // Function to reverse a linked list.
    Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            // 1. Save the next node
            next = curr.next;
            
            // 2. Reverse the current node's pointer
            curr.next = prev;
            
            // 3. Move pointers one position forward
            prev = curr;
            curr = next;
        }

        // prev becomes the new head
        return prev;
    }
}