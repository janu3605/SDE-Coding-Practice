package AssessmentCodes;

public class ConsecutiveSumGame {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        int x = 2;

        int[] val = { 1, 2, 3, 4 };

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + val[i];
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = i * x; j <= n; j++) {
                int currBlockSum = prefix[j] - prefix[j - x];
                int skip = dp[i][j - 1];

                int take = dp[i - 1][j - x] + currBlockSum;

                dp[i][j] = Math.max(skip, take);

            }
        }
        System.out.println(dp[k][n]);
    }
}
