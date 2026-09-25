package AssessmentCodes;

public class AndroidAppPurchases {
    public static void main(String[] args) {
        int[] upgradeCost = { 10, 20, 14, 40, 50 };
        int budget = 70;

        int n = upgradeCost.length;

        int mod = 1000000007;
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        int maxEnhancement = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (upgradeCost[i] <= budget) {
                budget -= upgradeCost[i];
                maxEnhancement = (maxEnhancement + pow[i]) % mod;
            }
        }
        System.out.println(maxEnhancement);
    }
}
