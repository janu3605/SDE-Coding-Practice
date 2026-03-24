package Sorting;

/**
 * MODEL: Interval Merging / Sorting * PROBLEM: The GPU Cluster Optimizer You
 * are a backend engineer managing a highly sought-after AI training server.
 * Researchers book time slots to run their models. Each reservation is
 * represented as an array of two numbers: [startTime, endTime]. * Often,
 * researchers book overlapping time slots. To optimize the server's power
 * management, the system needs to know the continuous blocks of time the server
 * will be active. * Your task is to take all the requested reservations and
 * merge any that overlap into single, continuous blocks of time. * * INPUT: -
 * reservations (a 2D array of integers, where each sub-array is [start, end]) *
 * OUTPUT: - A 2D array of integers representing the merged, non-overlapping
 * active blocks.
 *
 * EXAMPLE 1: Input: reservations = [[1, 3], [2, 6], [8,10],[15, 18]] Output:
 * [[1, 6], [8, 10], [15, 18]]
 *
 * Explanation: Since [1, 3] and [2, 6] overlap, they merge into [1, 6].
 */
import java.util.*;

public class ClusterOptimizer {

    public static int[][] mergeReservations(int[][] reservations) {
        List<int[]> merged = new ArrayList<>();

        Arrays.sort(reservations, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] current : reservations) {
            if (merged.isEmpty() || current[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(current);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(current[1], merged.get(merged.size() - 1)[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] inpt = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        int[][] result = mergeReservations(inpt);

        for (int[] i : result) {
            System.out.print(i[0] + "," + i[1] + "  ");
        }
    }
}
