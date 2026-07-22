// Scenario: You are monitoring a router's data queue over several seconds. The router can process a maximum amount of data in a single burst without dropping packets. You want to find the longest continuous timeframe where the total incoming data does not overwhelm the router's burst capacity.
// Problem: Given an array of positive integers incoming_traffic representing MB/s per second, and an integer max_capacity, find the length of the longest contiguous subarray whose sum is strictly less than or equal to max_capacity.

// Input: incoming_traffic = [3, 1, 2, 7, 4, 2, 1, 1, 5], max_capacity = 8
// Output: 4
// Explanation: The longest valid subarray is [4, 2, 1, 1] which sums to 8.
import java.util.*;

public class SustainedNetworkCapacity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] incoming_traffic = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max_capacity = sc.nextInt();

        int max_burst = MaxBurstSubarray(incoming_traffic, max_capacity);
        System.out.println(max_burst);
    }

    public static int MaxBurstSubarray(int[] incoming_traffic, int max_capacity) {
        int max = 0;
        int left = 0;
        int curr_capacity = 0;

        for (int right = 0; right < incoming_traffic.length; right++) {
            curr_capacity += incoming_traffic[right];

            while (curr_capacity > max_capacity && left <= right) {
                curr_capacity -= incoming_traffic[left];
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
