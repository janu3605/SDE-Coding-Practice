package DynamicProgramming;

// scenario: you are deploying a critical update to a remote edge router. the router only has a strict amount of flash memory available for new features. you have a list of optional firmware modules you can install. each module takes up a specific amount of memory (weight) and provides a specific performance boost score (value). you cannot install half a module; it's all or nothing.
// problem: given two integer arrays memory_cost and boost_score of length n, and an integer max_memory, return the maximum performance boost you can achieve without the total memory cost exceeding max_memory.
// input: memory_cost = [10, 20, 30], boost_score = [60, 100, 120], max_memory = 50
// output: 220 (taking the second and third modules: 20 + 30 = 50 memory, 100 + 120 = 220 boost).
// your hint:
// this is a classic dynamic programming problem that requires a 2d array (a table) built from the bottom up. the rows are the modules you can choose from, and the columns represent every possible memory limit from 0 all the way up to max_memory.
// as you fill out the grid, you need to ask yourself the golden dp question for every single box: "if my router had exactly this much memory right now, is my total boost higher if i completely ignore this new module, or if i install it and add its score to whatever the best score was for the remaining memory space?"
import java.util.*;

public class edgerouteroptimization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] memory_cost = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] boost_score = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int max_memory = sc.nextInt();

        int optimizedBoost = maxPerformanceBoost(memory_cost, boost_score, max_memory);
        System.out.println(optimizedBoost);
    }

    public static int maxPerformanceBoost(int[] memory_cost, int[] boost_score, int max_memory) {
        int n = memory_cost.length;
        int[][] dp = new int[n + 1][max_memory + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= max_memory; j++) {
                if (memory_cost[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], boost_score[i - 1] + dp[i - 1][j - memory_cost[i - 1]]);
                }
            }
        }

        return dp[n][max_memory];

    }
}