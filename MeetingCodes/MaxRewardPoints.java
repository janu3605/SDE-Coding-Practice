/*
Alex is given a path containing N nodes. Each node contains an associated reward value.  
He wants to maximize the sum of reward points collected from non-adjacent nodes along this path.  
However, there is a unique rule: Alex can select a node and its immediate predecessor in the path is negative. 
If the predecessor has a negative value, he must include both nodes in the sum and subtract the value of the 
negative node.  

input =  [1, 4, 8, -3, 10, 6, 1] 
output = 13
*/
package MeetingCodes;

public class MaxRewardPoints {
    public static void main(String[] args) {
        int[] array = { 1, 4, 8, -3, 10, 6, 1 };
        System.out.println(solve(array.length - 1, array));
    }

    public static int solve(int i, int[] array) {
        if (i < 0)
            return 0;
        if (i == 0)
            return Math.max(0, array[0]);

        int skip = solve(i - 1, array);
        int takeAlone = Integer.MIN_VALUE;
        if (array[i - 1] >= 0) {
            takeAlone = array[i] + solve(i - 2, array);
        }
        int takePair = Integer.MIN_VALUE;
        if (array[i - 1] < 0) {
            takePair = (array[i] - array[i - 1]) + solve(i - 3, array);
        }
        return Math.max(skip, Math.max(takeAlone, takePair));
    }
}

/*
 * import java.util.*;
 * 
 * public class MaximumRewardPoints {
 * 
 * public static int maxRewardPoints(int N, int[] A) {
 * if (N == 0) return 0;
 * if (N == 1) return Math.max(0, A[0]);
 * 
 * int[] dp = new int[N];
 * 
 * // Base case for index 0
 * dp[0] = Math.max(0, A[0]);
 * 
 * for (int i = 1; i < N; i++) {
 * // Choice 1: Do not select node i
 * int option1 = dp[i - 1];
 * 
 * // Choice 2: Select node i alone (Only valid if predecessor A[i-1] >= 0)
 * int option2 = Integer.MIN_VALUE;
 * if (A[i - 1] >= 0) {
 * int prev = (i >= 2) ? dp[i - 2] : 0;
 * option2 = A[i] + prev;
 * }
 * 
 * // Choice 3: Select node i along with negative predecessor A[i-1]
 * int option3 = Integer.MIN_VALUE;
 * if (A[i - 1] < 0) {
 * int prev = (i >= 3) ? dp[i - 3] : 0;
 * // Subtracting negative A[i-1] adds its absolute magnitude
 * option3 = (A[i] - A[i - 1]) + prev;
 * }
 * 
 * dp[i] = Math.max(option1, Math.max(option2, option3));
 * }
 * 
 * return dp[N - 1];
 * }
 * 
 * public static void main(String[] args) {
 * int N = 7;
 * int[] A = {1, 4, 8, -3, 10, 6, 1};
 * 
 * System.out.println("Maximum Reward Points: " + maxRewardPoints(N, A));
 * }
 * }
 */