import java.util.*;

public class LongestSubarrayProgram {

    public static int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxDq = new ArrayDeque<>(); // decreasing deque
        Deque<Integer> minDq = new ArrayDeque<>(); // increasing deque

        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain decreasing deque for maximum
            while (!maxDq.isEmpty() && maxDq.peekLast() < nums[right]) {
                maxDq.pollLast();
            }
            maxDq.offerLast(nums[right]);

            // Maintain increasing deque for minimum
            while (!minDq.isEmpty() && minDq.peekLast() > nums[right]) {
                minDq.pollLast();
            }
            minDq.offerLast(nums[right]);

            // If window invalid → shrink from left
            while (maxDq.peekFirst() - minDq.peekFirst() > limit) {

                if (maxDq.peekFirst() == nums[left]) {
                    maxDq.pollFirst();
                }
                if (minDq.peekFirst() == nums[left]) {
                    minDq.pollFirst();
                }

                left++; // shrink
            }

            // Update result
            result = Math.max(result, right - left + 1);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {8, 2, 4, 7};
        int limit = 4;

        int result = longestSubarray(nums, limit);

        System.out.println("Longest Subarray Length: " + result);
    }
}
