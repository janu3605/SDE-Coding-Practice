// Scenario: You are analyzing the signal strength of a cell tower over time. A signal period is considered "stable" if the difference in signal strength between any two adjacent time intervals is strictly less than 2.
// Problem: Given an integer array signal_strengths, find the length of the longest contiguous subarray that represents a stable signal period.

// Input: signal_strengths = [5, 4, 5, 5, 6, 7, 8, 4]
// Output: 5
// Explanation: The longest stable subarray is [5, 4, 5, 5, 6]. The absolute difference between all adjacent elements in this subarray is less than 2 (e.g., |5 - 4| = 1, |4 - 5| = 1, |5 - 5| = 0, |5 - 6| = 1).
// Concepts Tested: Sliding window, array traversal, edge case handling.
import java.util.*;

public class LongestStableSignal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] signal_strengths = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(LongestStable(signal_strengths));

        sc.close();
    }

    public static int LongestStable(int[] signal_strengths) {
        int i = 0;
        int max = 0;
        int start = 0;

        for (int j = 1; j < signal_strengths.length; j++) {
            if (Math.abs(signal_strengths[i] - signal_strengths[j]) < 2) {
                max = Math.max(max, j - start);
            } else {
                start = i;
            }
            i++;
            j++;
        }
        return max;
    }
}
