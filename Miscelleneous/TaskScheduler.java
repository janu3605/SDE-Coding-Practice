package Miscelleneous;
// package Macilaneous;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * MODEL: Heap / Priority Queue * PROBLEM: The Latency Optimizer You are
 * managing a cluster of cloud servers. Several tasks are submitted
 * simultaneously, each with a specific "processing time." To minimize the
 * average wait time for users, you want to process the SHORTEST tasks first. *
 * However, the system can only handle `K` tasks at a time. Your goal is to find
 * the total processing time of the `K` shortest tasks. * * INPUT: - taskTimes
 * (an array of integers) - k (the number of tasks to select) * OUTPUT: - An
 * integer representing the sum of the K smallest values. * EXAMPLE 1: Input:
 * taskTimes = [7, 10, 4, 3, 20, 15], k = 3 Output: 14 Explanation: The 3
 * smallest tasks are 3, 4, and 7. Sum = 14. * EXAMPLE 2: Input: taskTimes = [1,
 * 2, 3], k = 1 Output: 1
 */
public class TaskScheduler {

    public static int sumOfKSmallest(int[] taskTimes, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int time : taskTimes) {
            minHeap.add(time);
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += minHeap.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inpt = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int k = sc.nextInt();
        System.out.println(sumOfKSmallest(inpt, k));
    }
}
