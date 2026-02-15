import java.util.Arrays;
import java.util.Stack;

public class FinalPricesProgram {

    public static int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            // Resolve discounts
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                result[idx] = prices[idx] - prices[i];
            }

            stack.push(i);
        }

        // Remaining items get no discount
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = prices[idx];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] prices = {8, 4, 6, 2, 3};

        int[] result = finalPrices(prices);

        System.out.println("Final Prices:");
        System.out.println(Arrays.toString(result));
    }
}
