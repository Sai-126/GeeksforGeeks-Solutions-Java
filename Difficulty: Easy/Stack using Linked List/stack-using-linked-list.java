class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class myStack {

    StackNode top;
    int size;

    myStack() {
        top = null;
        size = 0;
    }

    void push(int x) {
        StackNode newNode = new StackNode(x);
        newNode.next = top;
        top = newNode;
        size++;
    }

    void pop() {
        if (top == null) return;
        top = top.next;
        size--;
    }

    int peek() {
        if (top == null) return -1;
        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return size;
    }
}