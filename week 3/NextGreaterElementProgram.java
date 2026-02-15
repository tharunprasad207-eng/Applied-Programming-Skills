import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementProgram {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Build next greater map for nums2
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Remaining numbers have no next greater
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        // Build result for nums1
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};

        int[] result = nextGreaterElement(nums1, nums2);

        System.out.println("Result:");
        System.out.println(Arrays.toString(result));
    }
}
