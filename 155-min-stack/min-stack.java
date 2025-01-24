class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int val) {
        int min = Integer.MIN_VALUE;
        if(stack.isEmpty()) {
            min = val;
        } else {
            min = minStack.peekFirst();
            if(val < min) {
                min = val;
            };
        }
        stack.addFirst(val);
        minStack.addFirst(min);
    }
    
    public void pop() {
        stack.removeFirst();
        minStack.removeFirst();
    }
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */