class MinStack {

    Stack<Integer> temp;
    Stack<Integer> st;

    public MinStack() {
        this.st = new Stack<>();
        this.temp = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if (temp.isEmpty() || val <= temp.peek()) {
            temp.push(val);
        }
    }
    
    public void pop() {
        int val = st.pop();
        if (temp.peek() == val) {
            temp.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return temp.peek();
    }
}
