
/**
 * MODEL: Monotonic Stack
 * * PROBLEM: The Skyline Observation Deck
 * You are an architect designing a new city skyline. You are given an array
 * of integers representing the heights of a row of buildings from left to right.
 * * For each building, you want to find the nearest building to its RIGHT
 * that is strictly TALLER than it. This will help determine where to place
 * bridges or observation decks.
 * * Your task is to return an array where the value at each index is the height
 * of the next taller building. If no taller building exists to the right,
 * use -1 for that position.
 * * * INPUT:
 * - heights (an array of integers)
 * * OUTPUT:
 * - An array of integers representing the next taller building's height.
 * * EXAMPLE 1:
 * Input: heights = [4, 5, 2, 25]
 * Output: [5, 25, 25, -1]
 * Explanation:
 * - For 4, the next taller is 5.
 * - For 5, the next taller is 25.
 * - For 2, the next taller is 25.
 * - For 25, there is nothing taller to the right.
 * * EXAMPLE 2:
 * Input: heights = [13, 7, 6, 12]
 * Output: [-1, 12, 12, -1]
 */


// public static int[] findNextTaller(int[] heights) {
//     int max = heights[heights.length - 1];
//     int[] ans = new int[heights.length];
//     ans[heights.length - 1] = -1;
//     for (int i = heights.length - 1; i >= 0; i--) {
//         ans[i] = heights[i] > max ? -1 : max;
//         max = Math.max(max, heights[i]);
//     }
//     return ans;
// }


import java.util.*;

public class SkylineArchitect {

    public static int[] findNextTaller(int[] heights) {
        int[] ans = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(heights[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] inpt = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] res = findNextTaller(inpt);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
