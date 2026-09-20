package DeltaX_Codes;

import java.util.*;

// find all the different ways to add up numbers from a given list to hit a specific target number. the rules are that you can only use each number from the list once per combination, and your final answer shouldn't have duplicate combinations.
// input: an array of integers candidates and an integer target.
// output: a list of lists containing the valid combinations.
// example input: candidates = [10, 1, 2, 7, 6, 1, 5], target = 8
// example output: [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
public class CombineSum {
    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int[] candidates, int target, int start, List<Integer> current,
            List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
