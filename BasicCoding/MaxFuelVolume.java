
public class MaxFuelVolume {

    public static void main(String[] args) {
        int n = 5;
        int k = 105;

        int[] prices = { 10, 10, 40, 50, 90 };
        int[] volumes = { 10, 20, 20, 50, 150 };

        int result = getMaxVolumeRecursive(prices, volumes, n, k, 0);
        System.out.println(result);
    }

    public static int getMaxVolumeRecursive(int[] prices, int[] volumes, int n, int budget, int currentIndex) {
        // Base Case 1: We have considered all fuel options
        if (currentIndex >= n) {
            return 0;
        }

        // Base Case 2: We are out of budget
        if (budget == 0) {
            return 0;
        }

        // Choice 1: Skip the current fuel option
        int skip = getMaxVolumeRecursive(prices, volumes, n, budget, currentIndex + 1);

        // Choice 2: Take the current fuel option (only if we can afford it)
        int take = 0;
        if (prices[currentIndex] <= budget) {
            take = volumes[currentIndex]
                    + getMaxVolumeRecursive(prices, volumes, n, budget - prices[currentIndex], currentIndex + 1);
        }

        // Return whichever choice gave us more total volume
        return Math.max(skip, take);
    }
}
