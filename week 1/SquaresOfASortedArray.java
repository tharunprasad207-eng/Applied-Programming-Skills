  public class SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {

        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int k = n - 1;

        int[] res = new int[n];

        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[k] = nums[l] * nums[l];
                l++;
            } else {
                res[k] = nums[r] * nums[r];
                r--;
            }
            k--;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = sortedSquares(nums);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
