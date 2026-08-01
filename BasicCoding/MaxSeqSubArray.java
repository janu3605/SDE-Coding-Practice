
public class MaxSeqSubArray {

    public static void main(String[] args) {
        int[] nums = {-1, 18, -2, 18, -2, 16, -213, 11};
        int maxSum = nums[1];
        boolean sign;
        if (nums[0] > 0) {
            sign = true;
        } else {
            sign = false;
        }
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(maxSum, currSum);

            if (sign == false) {
                if (nums[i] > 0) {
                    sign = true;
                    currSum += nums[i];
                } else {
                    currSum = nums[i];
                }
            } else {
                if (nums[i] < 0) {
                    sign = false;
                    currSum += nums[i];
                } else {
                    currSum = nums[i];
                }
            }
        }
        System.out.println(maxSum);
    }
}
