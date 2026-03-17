
/**
 * MODEL: Sliding Window
 * PROBLEM: Automated Checkout Buffer
 * A major supermarket chain is upgrading its automated checkout systems.
 * The conveyor belt brings items to the scanner one by one, represented by an array of their weights.
 * The new scanner has a temporary memory buffer that can only handle a maximum total weight, `W`, at any given time.
 * To keep the belt moving smoothly and avoid system crashes, the scanner must process a *contiguous* sequence of items.
 *
 * INPUT:
 * - weights (array of integers)
 * - maxWeight (integer)
 *
 * OUTPUT:
 * - Return an `int` representing the maximum number of consecutive items that can be scanned.
 *
 * EXAMPLE:
 * Input: weights = [3, 1, 2, 4, 2, 1, 1, 5], maxWeight = 8
 * Output: 4 (The sequence [4, 2, 1, 1] has a weight of 8 and length 4)
 */
import java.util.*;

public class CheckoutBuffer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] weights = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxWt = sc.nextInt();

        System.out.println(MaxItems(weights, maxWt));

        sc.close();
    }

    public static int MaxItems(int[] weights, int maxWt) {
        int i = 0;
        int maxCount = 0;
        int currWt = 0;

        for (int j = 0; j < weights.length; j++) {
            currWt += weights[j];

            while (currWt > maxWt && i <= j) {
                currWt -= weights[i];
                i++;
            }
            maxCount = Math.max(maxCount, j - i + 1);
        }
        return maxCount;

    }

    // public static ArrayList Maxitems(int[] weights, int max Wt) {
//    Arrays.sort(weights);
    //     ArrayList<Integer> weight = new ArrayList<>();
    //     int wt = 0;
    //         if (wt + ele > maxWt) {
    //         }
    //         wt += ele;
    //         weight.add(ele);
    //     }
    //     return weight;
    // }
}
