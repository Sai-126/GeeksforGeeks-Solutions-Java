/*
class Node {
    int data;
    Node next;
}
*/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head;
        Node fast = head;

        // Phase 1: Detect Loop
        boolean loopExists = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        // If no loop is found, just return
        if (!loopExists) return;

        // Phase 2: Find the starting point of the loop
        slow = head;
        
        // Special case: Loop starts at the head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null; // Break the loop
            return;
        }

        // Standard case: Move both one step at a time
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Phase 3: Break the loop
        fast.next = null;
    }
}