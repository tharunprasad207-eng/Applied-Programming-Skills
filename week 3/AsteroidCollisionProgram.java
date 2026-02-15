import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollisionProgram {

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            boolean add = true;

            while (!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0) {

                int val1 = stack.peek();
                int val2 = asteroids[i];

                // Same size
                if (val1 + val2 == 0) {
                    stack.pop();
                    add = false;
                    break;
                }
                // Incoming asteroid bigger
                else if (val1 + val2 < 0) {
                    stack.pop();
                }
                // Stack asteroid bigger
                else {
                    add = false;
                    break;
                }
            }

            if (add) {
                stack.push(asteroids[i]);
            }
        }

        // Convert stack to array
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] asteroids = {5, 10, -5};

        int[] result = asteroidCollision(asteroids);

        System.out.println("Final Asteroids:");
        System.out.println(Arrays.toString(result));
    }
}
