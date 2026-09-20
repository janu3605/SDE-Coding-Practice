package MeetingCodes;

import java.util.*;

public class PrimeTransformation {

    // Helper class to store current number string and operations spent
    static class State {
        String numStr;
        int cost;

        State(String numStr, int cost) {
            this.numStr = numStr;
            this.cost = cost;
        }
    }

    public static long getSmallestPrimeQueue(long N, int K) {
        String startStr = String.valueOf(N);
        Queue<State> queue = new LinkedList<>();

        // Track visited (numStr -> minCost) to avoid redundant queue pushes
        Map<String, Integer> visited = new HashMap<>();

        queue.add(new State(startStr, 0));
        visited.put(startStr, 0);

        long minPrime = Long.MAX_VALUE;

        while (!queue.isEmpty()) {
            State curr = queue.poll();
            long val = Long.parseLong(curr.numStr);

            // 1. Check if current number is prime
            if (isPrime(val)) {
                minPrime = Math.min(minPrime, val);
            }

            // If we reached max allowed operations K, don't generate further states
            if (curr.cost == K)
                continue;

            char[] arr = curr.numStr.toCharArray();

            // 2. Try changing each digit position independently by +1 or -1
            for (int i = 0; i < arr.length; i++) {
                char originalChar = arr[i];

                // --- TRY INCREMENTING (+1) ---
                if (originalChar < '9') { // Boundary check: max 9
                    arr[i] = (char) (originalChar + 1);
                    String nextStr = new String(arr);
                    int nextCost = curr.cost + 1;

                    if (!visited.containsKey(nextStr) || visited.get(nextStr) > nextCost) {
                        visited.put(nextStr, nextCost);
                        queue.add(new State(nextStr, nextCost));
                    }
                }

                // --- TRY DECREMENTING (-1) ---
                char minAllowed = (i == 0) ? '1' : '0'; // Prevent leading zero on index 0
                if (originalChar > minAllowed) { // Boundary check: min 0 or 1
                    arr[i] = (char) (originalChar - 1);
                    String nextStr = new String(arr);
                    int nextCost = curr.cost + 1;

                    if (!visited.containsKey(nextStr) || visited.get(nextStr) > nextCost) {
                        visited.put(nextStr, nextCost);
                        queue.add(new State(nextStr, nextCost));
                    }
                }

                // Backtrack character array back to original state for the next loop index
                arr[i] = originalChar;
            }
        }

        return (minPrime == Long.MAX_VALUE) ? -1 : minPrime;
    }

    private static boolean isPrime(long n) {
        if (n < 2)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Smallest Prime: " + getSmallestPrimeQueue(231, 2));
    }
}

/*
 * import java.util.*;
 * 
 * public class PrimeTransformation {
 * 
 * private static long minPrime = Long.MAX_VALUE;
 * 
 * public static long getSmallestPrime(long N, int K) {
 * String sN = String.valueOf(N);
 * minPrime = Long.MAX_VALUE;
 * 
 * // Explore all valid digit combinations within cost K
 * backtrack(0, 0, 0L, sN, K);
 * 
 * return (minPrime == Long.MAX_VALUE) ? -1 : minPrime;
 * }
 * 
 * private static void backtrack(int idx, int currentCost, long currentNum,
 * String sN, int K) {
 * // Prune if cost exceeds allowance
 * if (currentCost > K) return;
 * 
 * // Base Case: All digits placed
 * if (idx == sN.length()) {
 * if (isPrime(currentNum)) {
 * minPrime = Math.min(minPrime, currentNum);
 * }
 * return;
 * }
 * 
 * int originalDigit = sN.charAt(idx) - '0';
 * int startDigit = (idx == 0) ? 1 : 0; // Prevent leading zeros for the first
 * digit
 * 
 * // Try changing current digit to d (where 0 <= d <= 9)
 * for (int d = startDigit; d <= 9; d++) {
 * int cost = Math.abs(originalDigit - d);
 * if (currentCost + cost <= K) {
 * backtrack(idx + 1, currentCost + cost, currentNum * 10 + d, sN, K);
 * }
 * }
 * }
 * 
 * // Helper method to check primality in O(sqrt(N))
 * private static boolean isPrime(long n) {
 * if (n < 2) return false;
 * if (n == 2 || n == 3) return true;
 * if (n % 2 == 0 || n % 3 == 0) return false;
 * 
 * for (long i = 5; i * i <= n; i += 6) {
 * if (n % i == 0 || n % (i + 2) == 0) return false;
 * }
 * return true;
 * }
 * 
 * public static void main(String[] args) {
 * long N = 231;
 * int K = 2;
 * 
 * System.out.println("Smallest Prime: " + getSmallestPrime(N, K));
 * }
 * }
 */
