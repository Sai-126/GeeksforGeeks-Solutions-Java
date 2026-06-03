/* Structure of Node
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    // Alias 1: Standard GFG naming convention
    public boolean isCircular(Node head) {
        // Condition: An empty linked list is always a circular linked list
        if (head == null) {
            return true;
        }

        // Start traversing from the node right after the head
        Node current = head.next;

        // Traverse the list until we hit null or find the head node again
        while (current != null && current != head) {
            current = current.next;
        }

        // If current equals head, it wrapped all the way back around
        return (current == head);
    }
}