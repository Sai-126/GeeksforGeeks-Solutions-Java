class twoStacks {
    int[] arr;
    int size;
    int top1;
    int top2;

    // Initialize the two stacks inside a single array
    twoStacks() {
        size = 100; // Default size as per constraints
        arr = new int[size];
        top1 = -1;         // Points before the first element of Stack 1
        top2 = size;       // Points after the first element of Stack 2
    }

    // Function to push an integer into stack1.
    void push1(int x) {
        // Space is available if there is at least one empty slot between top1 and top2
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
        }
    }

    // Function to push an integer into stack2.
    void push2(int x) {
        // Space is available if there is at least one empty slot between top1 and top2
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
        }
    }

    // Function to remove an element from top of stack1.
    int pop1() {
        // Check for underflow
        if (top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        return -1;
    }

    // Function to remove an element from top of stack2.
    int pop2() {
        // Check for underflow
        if (top2 < size) {
            int x = arr[top2];
            top2++;
            return x;
        }
        return -1;
    }
}