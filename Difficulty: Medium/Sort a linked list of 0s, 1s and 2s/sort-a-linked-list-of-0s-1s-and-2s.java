class Solution {
    public Node segregate(Node head) {
        
        if (head == null || head.next == null) return head;
        
        int[] count = new int[3];
        
        Node temp = head;
        
        while (temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }
        
        temp = head;
        int i = 0;
        
        while (temp != null) {
            if (count[i] == 0) {
                i++;
            } else {
                temp.data = i;
                count[i]--;
                temp = temp.next;
            }
        }
        
        return head;
    }
}