package AssessmentCodes;

public class IlluminatedBulbs {
    public static void main(String[] args) {
        int n = 3;
        int k = 2;
        int[] pos = { 1, 5, 10 };

        // Arrays.sort(pos);

        int low = 0;
        int high = pos[n - 1] - pos[0];

        int optimalrange = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isFeasable(pos, k, mid)) {
                optimalrange = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(optimalrange);
    }

    public static boolean isFeasable(int[] pos, int k, int range) {
        int bulbesUsed = 1;
        int coverageEnd = pos[0] + (2 * range);

        for (int i = 1; i < pos.length; i++) {
            if (pos[i] > coverageEnd) {
                bulbesUsed++;
                coverageEnd = pos[i] + (2 * range);
            }
        }
        return bulbesUsed <= k;
    }
}
