import java.util.Arrays;

public class SumAbsoluteDifferences {

    public static int[] getSumAbsoluteDifferences(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        int total = 0;
        int left = 0;

        // Calculate total sum
        for (int x : nums) {
            total += x;
        }

        for (int i = 0; i < n; i++) {

            int right = total - left - nums[i];

            res[i] = nums[i] * i - left 
                   + right - nums[i] * (n - i - 1);

            left += nums[i];
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 5};

        int[] result = getSumAbsoluteDifferences(nums);

        System.out.println("Output: " + Arrays.toString(result));
    }
}
}