package AssessmentCodes;
/*
Urban WiFi Coverage PlanA telecom provider plans to install $K$ WiFi towers along a straight highway. You are given an array positions representing coordinates of candidate sites where towers can be built.
To minimize signal interference and maximize coverage distribution, you need to select $K$ sites such that the minimum distance between any two adjacent chosen towers is as large as possible.

Input:positions: An integer array representing candidate tower locations.K: An integer representing the number of towers that must be installed.Output: An integer representing the maximum possible value of the minimum distance between any two placed towers.
*/

import java.util.*;

public class UrbanWiFiCoveragePlan {

    public static int maxMinDistance(int[] positions, int K) {
        if (positions == null || positions.length < K)
            return 0;

        // Sort positions to process candidate sites sequentially
        Arrays.sort(positions);

        int low = 1;
        int high = positions[positions.length - 1] - positions[0];
        int result = 0;

        // Binary search for the maximum achievable minimum distance
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceTowers(positions, K, mid)) {
                result = mid; // 'mid' works, record it and try for a larger distance
                low = mid + 1;
            } else {
                high = mid - 1; // 'mid' is too large, search lower half
            }
        }

        return result;
    }

    // Helper method to greedily check if we can place K towers with at least
    // minDist separation
    private static boolean canPlaceTowers(int[] positions, int K, int minDist) {
        int count = 1; // Always place the first tower at the first candidate site
        int lastPlaced = positions[0];

        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - lastPlaced >= minDist) {
                count++;
                lastPlaced = positions[i];
            }
            if (count >= K) {
                return true; // Successfully placed all K towers
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] positions = { 1, 5, 9, 12, 14, 18 };
        int K = 3;

        int maxDistance = maxMinDistance(positions, K);
        System.out.println("Maximum Minimum Distance: " + maxDistance); // Output: 8
    }
}
