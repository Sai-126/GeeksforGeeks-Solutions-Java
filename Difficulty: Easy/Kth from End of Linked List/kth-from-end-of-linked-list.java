/*
class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}
*/

class Solution {
    // Function to find the kth node from the end of a linked list.
    int getKthFromLast(Node head, int k) {
        if (head == null || k <= 0) return -1;

        Node first = head;
        Node second = head;

        // 1. Move 'first' k steps ahead
        for (int i = 0; i < k; i++) {
            // If k is greater than the number of nodes
            if (first == null) return -1;
            first = first.next;
        }

        // 2. Move both pointers until 'first' hits the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // 'second' is now at the kth node from the end
        return second.data;
    }
}