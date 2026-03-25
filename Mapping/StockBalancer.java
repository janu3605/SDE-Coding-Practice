package Mapping;

/**
 * MODEL: Hash Mapping / Subarray Logic * PROBLEM: The Stock Market "Balance"
 * Finder You are working for a fintech startup. You have an array representing
 * the daily performance of a stock over N days. Each day is marked as either 1
 * (Stock went UP) or 0 (Stock went DOWN). * To find the most "stable" period
 * for this stock, your manager wants to find the LONGEST contiguous period
 * (subarray) where the number of UP days is exactly equal to the number of DOWN
 * days. * Your task is to return the length of this longest balanced subarray.
 * * * INPUT: - days (an array of integers containing only 0s and 1s) * OUTPUT:
 * - An integer representing the length of the longest balanced subarray. *
 * EXAMPLE 1: Input: days = [0, 1] Output: 2 Explanation: The whole array has
 * one 0 and one 1. * EXAMPLE 2: Input: days = [0, 1, 0, 0, 1, 1, 0] Output: 6
 * Explanation: The subarray [0, 1, 0, 0, 1, 1] (from index 0 to 5) has three 0s
 * and three 1s.
 */

import java.util.*;

public class StockBalancer {

    public static int findMaxLength(int[] days) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int count = 0;

        for (int i = 0; i < days.length; i++) {

            count += days[i] == 0 ? -1 : 1;

            if (map.containsKey(count)) {
                int prevIdx = map.get(count);
                int currIdx = i - prevIdx;
                max = Math.max(max, currIdx);
            } else {
                map.put(count, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inpt = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int result = findMaxLength(inpt);
        System.out.println(result);
    }
}
