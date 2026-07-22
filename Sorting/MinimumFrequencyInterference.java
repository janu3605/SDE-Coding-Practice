package Sorting;

// Scenario: A cell tower is assigning frequency bands to new mobile devices. To prevent signal interference, you want to identify the two devices whose assigned frequencies are the closest to each other so you can re-calibrate them.
// Problem: Given an array of integers frequencies representing assigned MHz bands, find the minimum absolute difference between any two elements in the array. Return that minimum difference.

// Input: frequencies = [850, 2100, 1900, 800, 2600, 1850]
// Output: 50
// Explanation: The closest frequencies are 1900 and 1850 (difference of 50), or 850 and 800 (difference of 50).
import java.util.*;

public class MinimumFrequencyInterference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] frequencies = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int min_diff = MinFrequencyDifference(frequencies);
        System.out.println(min_diff);
    }

    public static int MinFrequencyDifference(int[] frequencies) {
        Arrays.sort(frequencies);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < frequencies.length; i++) {
            min = Math.min(Math.abs(frequencies[i] - frequencies[i-1]), min);
        }
        return min;
    }
}
