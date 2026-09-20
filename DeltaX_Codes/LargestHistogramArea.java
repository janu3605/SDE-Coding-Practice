package DeltaX_Codes;

public class LargestHistogramArea {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        int maxArea = largestRectangleArea(heights);
        System.out.println(maxArea);
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int localMin = 0;
            if (heights[l] > heights[r]) {
                localMin = heights[r];
                r--;
            } else {
                localMin = heights[l];
                l++;
            }
            maxArea = 2 * localMin;
        }
        return maxArea;
    }
}
