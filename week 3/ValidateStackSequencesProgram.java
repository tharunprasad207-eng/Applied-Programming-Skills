import java.util.Stack;

public class ValidateStackSequencesProgram {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> st = new Stack<>();
        int j = 0;  // pointer for popped array

        for (int val : pushed) {

            st.push(val);

            // Keep popping while top matches popped[j]
            while (!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {

        int[] pushed1 = {1, 2, 3, 4, 5};
        int[] popped1 = {4, 5, 3, 2, 1};

        int[] pushed2 = {1, 2, 3, 4, 5};
        int[] popped2 = {4, 3, 5, 1, 2};

        System.out.println("Example 1:");
        System.out.println("Valid? " + validateStackSequences(pushed1, popped1));

        System.out.println("\nExample 2:");
        System.out.println("Valid? " + validateStackSequences(pushed2, popped2));
    }
}
