import java.util.Arrays;

public class NextGreaterPermutation {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // Step 1: Find the first decreasing element scanning from right to left
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If such an element is found, find the next largest element to its right
        if (i >= 0) {
            int j = nums.length - 1;
            // Step 2: Find the element just larger than nums[i]
            while (nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: Swap them
            swap(nums, i, j);
        }

        // Step 4: Reverse the suffix starting from i + 1 to the end
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 2 };
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums)); // Expected: [1, 4, 2, 3, 5]
    }
}