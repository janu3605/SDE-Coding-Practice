/*
    Here is the detailed problem statement derived directly from your code logic:
    Problem Title: Monster ClashProblem DescriptionIn the kingdom of Arrayland, $N$ monsters are standing in a straight lineup. Each monster at index $i$ has an integer power level represented by $A[i]$.
    
    A tournament is held until only one monster remains. In each round of the tournament:
    
    Select Candidate Monsters: Identify the monsters at the following three dynamic positions in the current lineup:The First monster (index 0)The Middle monster (index $\lfloor \text{size} / 2 \rfloor$)The Last monster (index $\text{size} - 1$)(If two or three of these positions point to the same monster due to small lineup sizes, duplicate indices are ignored).Calculate Clash Cost: Evaluate all possible unique pairs among the selected candidate monsters. The clash cost of a pair is defined as the Greatest Common Divisor ($\text{GCD}$) of their power levels.Determine the Battle: Find the pair of candidates that produces the minimum clash cost.If multiple candidate pairs tie for the minimum $\text{GCD}$, the pair that appears first during evaluation is selected.Eliminate a Monster:Add the minimum clash cost to the total tournament cost.Eliminate the monster that stands at the higher index between the chosen pair from the lineup.Shift the remaining monsters to close the gap.Return the total accumulated clash cost when only 1 monster remains in the lineup.
*/


package MeetingCodes;

import java.util.*;

public class MonsterClash {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int solve(int n, int[] a) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int x : a) {
            arr.add(x);
        }
        int total_cost = 0;
        while (arr.size() > 1) {
            int size = arr.size();
            Set<Integer> idxSet = new LinkedHashSet<>();
            idxSet.add(0);
            idxSet.add(size / 2);
            idxSet.add(size - 1);

            List<Integer> candidates = new ArrayList<>(idxSet);
            int mingcd = Integer.MAX_VALUE;
            int bestI = -1, bestJ = -1;

            for (int p = 0; p < candidates.size(); p++) {
                for (int q = p + 1; q < candidates.size(); q++) {
                    int i = candidates.get(p);
                    int j = candidates.get(q);

                    int currentGCD = gcd(arr.get(i), arr.get(j));
                    if (currentGCD < mingcd) {
                        mingcd = currentGCD;
                        bestI = i;
                        bestJ = j;
                    }
                }
            }
            total_cost += mingcd;
            arr.remove(Math.max(bestI, bestJ));
        }
        return total_cost;
    }
}
