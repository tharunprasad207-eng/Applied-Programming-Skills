import java.util.Stack;

public class MinStackProgram {

    static class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);

            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(2);

        System.out.println("Top: " + minStack.top());      // 2
        System.out.println("Min: " + minStack.getMin());  // 2

        minStack.pop();

        System.out.println("After Pop:");
        System.out.println("Top: " + minStack.top());      // 7
        System.out.println("Min: " + minStack.getMin());  // 3
    }
}
