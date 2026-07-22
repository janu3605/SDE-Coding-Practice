// scenario: you are analyzing the net data throughput of a specific cell tower over a series of milliseconds. some milliseconds have excellent data transfer (positive numbers), while others suffer from severe packet loss and interference (negative numbers). you need to find the specific continuous timeframe that yielded the highest overall net data transfer.
// problem: given an integer array throughput representing the net data transfer at each millisecond, find the contiguous subarray that has the largest sum and return its sum.

// input: throughput = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
// output: 6 (from the subarray [4, -1, 2, 1])
// your hint: don't use nested loops. set up two trackers: a current_sum and a max_sum. as you loop through the array exactly one time, add the current number to current_sum. the crucial kadane logic is this: if your current_sum ever drops below zero, it's dead weight. a negative running sum will only drag down the numbers that come after it. reset it to zero immediately before moving to the next number in the array.
import java.util.*;

public class peaksignalthroughput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] throughput = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int largest_subArr = peakSignal(throughput);
        System.out.println(largest_subArr);

    }

    public static int peakSignal(int[] throughput) {
        int maxThroughput = 0;
        int currentSum = 0;

        for (int i = 0; i < throughput.length; i++) {
            currentSum += throughput[i];
            maxThroughput = Math.max(currentSum, maxThroughput);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxThroughput;
    }

}
