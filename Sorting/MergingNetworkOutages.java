package Sorting;

// Scenario: A regional network experiences multiple localized outages. You are given the start and end times of these outages, but some of the reports overlap. You need to consolidate them into a clean report of distinct outage periods.
// Problem: Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the outage times in the input.
// Input: intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
// Output: [[1, 6], [8, 10], [15, 18]]
// Explanation: Since intervals [1, 3] and [2, 6] overlap, they are merged into [1, 6].
// Concepts Tested: Sorting algorithms, greedy approach.
import java.util.*;

public class MergingNetworkOutages {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int[][] merged = mergeIntervals(intervals);
        for (int[] interval : merged) {
            System.out.println(Arrays.toString(interval));
        }
        sc.close();
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        int[][] merged = new int[intervals.length][2];

        for (int k = 0; k < intervals.length - 1; k++) {

            if (intervals[k][1] > intervals[k + 1][0]) {
                intervals[k][1] = intervals[k + 1][1];

                merged[k][0] = intervals[k][0];
                merged[k][1] = intervals[k][1];

                k++;
            } else {
                merged[k][0] = intervals[k][0];
                merged[k][1] = intervals[k][1];
            }
        }
        merged[intervals.length - 1][0] = intervals[intervals.length - 1][0];
        merged[intervals.length - 1][1] = intervals[intervals.length - 1][1];
        return merged;
    }
}
