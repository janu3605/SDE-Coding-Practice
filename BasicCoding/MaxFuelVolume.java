
public class MaxFuelVolume {

    public static void main(String[] args) {
        int n = 5;
        int k = 105;

        int[] prices = {10, 10, 40, 50, 90};
        int[] volumes = {10, 20, 20, 50, 150};

        int currentCost = 0;

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            int price = prices[i];
            int volume = volumes[i];
            for (int j = k; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + volume);
            }
        }
        System.out.println(dp[k]);
    }
}
