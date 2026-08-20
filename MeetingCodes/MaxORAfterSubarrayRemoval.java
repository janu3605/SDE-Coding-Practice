package PowerCoding;

public class MaxORAfterSubarrayRemoval {

    public static int maxOR(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k >= n) return 0; // If k >= n, no elements remain

        // Step 1: Precompute Prefix ORs
        int[] prefOR = new int[n];
        prefOR[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefOR[i] = prefOR[i - 1] | arr[i];
        }

        // Step 2: Precompute Suffix ORs
        int[] suffOR = new int[n];
        suffOR[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffOR[i] = suffOR[i + 1] | arr[i];
        }

        int maxRemainingOR = 0;

        // Step 3: Iterate through all possible starting indices for subarray removal
        for (int i = 0; i <= n - k; i++) {
            int leftOR = (i > 0) ? prefOR[i - 1] : 0;
            int rightOR = (i + k < n) ? suffOR[i + k] : 0;

            int currentOR = leftOR | rightOR;
            maxRemainingOR = Math.max(maxRemainingOR, currentOR);
        }

        return maxRemainingOR;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 8, 16};
        int k = 2;

        System.out.println("Maximum Remaining OR: " + maxOR(arr, k));
        // Output: 28 (Binary 11100 -> formed by remaining elements 4, 8, 16)
    }
}