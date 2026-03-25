
/**
 * MODEL: Two Pointers (Opposite Ends)
 * * PROBLEM: The Water Reservoir Optimization
 * You are a civil engineer designing a massive water storage facility.
 * You are given an array of integers representing the heights of vertical
 * barriers placed at 1-unit intervals.
 * * You need to choose two barriers to form a container, such that the
 * container holds the MOST amount of water.
 * * Note: You cannot slant the container. The amount of water is limited
 * by the shorter of the two barriers multiplied by the distance between them.
 * * * INPUT:
 * - heights (an array of integers)
 * * OUTPUT:
 * - An integer representing the maximum volume of water that can be stored.
 * * EXAMPLE 1:
 * Input: heights = [1, 8, 6, 2, 5, 4, 8, 3, 7]
 * Output: 49
 * Explanation: The barriers at index 1 (height 8) and index 8 (height 7)
 * form a container with width 7. Volume = min(8, 7) * 7 = 49.
 * * EXAMPLE 2:
 * Input: heights = [1, 1]
 * Output: 1
 */
public class ReservoirDesign {

    public static int maxWater(int[] heights) {
        int i = 0, j = heights.length - 1;
        int maxVolume = 0;

        while (i < j) {
            int currentVol = Math.min(heights[i], heights[j]) * (j - i);
            maxVolume = Math.max(currentVol, maxVolume);
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }

        }
        return maxVolume;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxWater(heights));
    }
}
