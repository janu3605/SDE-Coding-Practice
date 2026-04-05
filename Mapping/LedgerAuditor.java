
/**
 * MODEL: Prefix Sum + Hash Map
 * * PROBLEM: The Zero-Sum Transaction Audit
 * You are auditing a ledger of stock market transactions. Each integer
 * represents a gain (positive) or a loss (negative).
 * * A "balanced period" is a continuous sub-sequence of transactions
 * that sums up to exactly ZERO.
 * * Your task is to find the length of the LONGEST balanced period in the ledger.
 * * * INPUT:
 * - ledger (an array of integers)
 * * OUTPUT:
 * - An integer representing the length of the longest zero-sum sub-sequence.
 * * EXAMPLE 1:
 * Input: ledger = [1, -1, 5, -2, 3]
 * Output: 2
 * Explanation: [1, -1] sums to 0. Length is 2.
 * * EXAMPLE 2:
 * Input: ledger = [1, 2, -3, 3, -1, -2]
 * Output: 6
 * Explanation: The entire array [1, 2, -3, 3, -1, -2] sums to 0.
 * * EXAMPLE 3:
 * Input: ledger = [1, 2, 3]
 * Output: 0
 */
import java.util.*;

public class LedgerAuditor {

    public static int longestBalancedPeriod(int[] ledger) {
        int runningSum = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        // -> The Code is only right if balanced from first index. Wont be correct if in middle of array.  
        // for (int i = 0; i < ledger.length; i++) {
        //     runningSum += ledger[i];
        //     map.put(i, runningSum);
        //     if (map.get(i) == 0) {
        //         maxLength = i + 1;
        //     }
        // }
        // System.out.println(map.toString());

        
        for (int i = 0; i < ledger.length; i++) {
            runningSum += ledger[i];
            if (map.containsKey((runningSum))) {
                maxLength = Math.max(maxLength, i - map.get(runningSum));
            } else {
                map.put(runningSum, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inpt = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(longestBalancedPeriod(inpt));
    }

}
